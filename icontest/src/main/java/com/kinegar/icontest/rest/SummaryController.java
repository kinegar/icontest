package com.kinegar.icontest.rest;

import com.kinegar.icontest.model.dto.Summary;
import com.kinegar.icontest.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SummaryController {
    @Autowired
    private SummaryService summaryService;

    @GetMapping("/")
    public List<Summary> getSummary(){
        return summaryService.getSummaries();
    }
}
