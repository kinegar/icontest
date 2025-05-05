package com.kinegar.icontest.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.kinegar.icontest.model.extmodel.BookingList;
import com.kinegar.icontest.model.extmodel.MasterJenisKonsumsi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiService {
    private final RestTemplate restTemplate;

    @Value("${api.get.transaksi.pemesanan.ruangan}")
    private String getBookingListUrl;

    @Value("${api.get.master.jenis.konsumsi}")
    private String getMasterJenisKonsumsiUrl;


    public ApiService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<BookingList> getBookingList(){
        ResponseEntity<List<BookingList>> response =
                restTemplate.exchange(
                        getBookingListUrl,
                        HttpMethod.GET,
                        null,new ParameterizedTypeReference<List<BookingList>>(){});
        return response.getBody();
    }

    public List<MasterJenisKonsumsi> getMasterJenisKonsumsi(){
        ResponseEntity<List<MasterJenisKonsumsi>> response = restTemplate.exchange(
                getMasterJenisKonsumsiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MasterJenisKonsumsi>>(){});
        return response.getBody();
    }
}
