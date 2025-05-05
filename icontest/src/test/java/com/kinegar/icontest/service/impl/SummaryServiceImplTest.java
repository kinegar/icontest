package com.kinegar.icontest.service.impl;

import com.kinegar.icontest.api.ApiService;
import com.kinegar.icontest.model.dto.Summary;
import com.kinegar.icontest.service.SummaryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SummaryServiceImplTest {

    @Autowired
    SummaryServiceImpl summaryService;
    @Autowired
    ApiService apiService;

    @Test
    void getSummaries() {
        List<Summary> summaries = summaryService.getSummaries();
        assertFalse(summaries.isEmpty());
        Optional<Summary> summary = summaries.stream()
                .filter(s -> s.getRoomName().equals("Ruang Borobudur") && s.getOfficeName().equals("UID JAYA"))
                .findFirst();
        assertEquals(BigDecimal.valueOf(5940000),summary.get().getTotalConsumption());
    }

//    @Test
    void getDays(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth());
    }
}