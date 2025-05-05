package com.kinegar.icontest.service.impl;

import com.kinegar.icontest.api.ApiService;
import com.kinegar.icontest.model.dto.Summary;
import com.kinegar.icontest.model.extmodel.BookingList;
import com.kinegar.icontest.model.extmodel.Consumption;
import com.kinegar.icontest.model.extmodel.MasterJenisKonsumsi;
import com.kinegar.icontest.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

@Service
public class SummaryServiceImpl implements SummaryService {
    private ApiService apiService;

    @Autowired
    public SummaryServiceImpl(ApiService apiService){
        this.apiService = apiService;
    }

    private final long MAX_DAY_IN_MINUTES = 1440l;

    @Override
    public List<Summary> getSummaries() {
        List<MasterJenisKonsumsi> masterJenisKonsumsi = apiService.getMasterJenisKonsumsi();
        List<BookingList> bookingList = apiService.getBookingList();

        List<Summary> summaries = new ArrayList<>();
        for (BookingList book : bookingList){
            Summary summary = new Summary();

            summary.setRoomName(book.getRoomName());
            summary.setOfficeName(book.getOfficeName());

            LocalDateTime start = book.getStartTime();
            LocalDateTime finish = book.getEndTime();
            int totalDays = start.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
            long duration = finish.until(start, ChronoUnit.MINUTES);
            double percent = (double) duration / MAX_DAY_IN_MINUTES / totalDays * 100;
            percent = Math.abs(percent);
            summary.setUsagePercentage(percent);

            BigDecimal totalConsumption = new BigDecimal(0);
            Map<String,Integer> consumptionDetail = new HashMap<>();
            for (Consumption consumption : book.getListConsumption()){
                Optional<MasterJenisKonsumsi> master = masterJenisKonsumsi.stream()
                        .filter(detail -> consumption.getName().equals(detail.getName())).findAny();
                if (master.isPresent()){
                    Integer participant = book.getParticipants();
                    consumptionDetail.put(master.get().getName(), participant);
                    totalConsumption = totalConsumption.add(master.get().getMaxPrice().multiply(new BigDecimal(participant)));
                }
            }
            summary.setTotalConsumption(totalConsumption);
            summary.setConsumptionDetail(consumptionDetail);

            Optional<Summary>  optionalSummary = summaries.stream().filter(
                    s -> s.getRoomName().equals(summary.getRoomName()) && s.getOfficeName().equals(summary.getOfficeName()))
                    .findFirst();

            if (optionalSummary.isPresent()){
                Map<String,Integer> consumptionDetailExist = optionalSummary.get().getConsumptionDetail();
                for (Map.Entry<String ,Integer> entry : summary.getConsumptionDetail().entrySet()){
                    consumptionDetailExist.put(entry.getKey(),consumptionDetailExist.getOrDefault(entry.getKey(),0) + entry.getValue());
                }

                Double percentExist =  optionalSummary.get().getUsagePercentage();
                percentExist = percentExist + summary.getUsagePercentage();
                optionalSummary.get().setUsagePercentage(percentExist);

                BigDecimal totalConsumptionExist =  optionalSummary.get().getTotalConsumption();
                totalConsumptionExist = totalConsumptionExist.add(summary.getTotalConsumption());
                optionalSummary.get().setTotalConsumption(totalConsumptionExist);

            }else {
                summaries.add(summary);
            }
        }

        return summaries;
    }
}
