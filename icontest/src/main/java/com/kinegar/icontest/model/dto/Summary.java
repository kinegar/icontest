package com.kinegar.icontest.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Summary {
    private String officeName;
    private String roomName;
    private Double usagePercentage;
    private BigDecimal totalConsumption;
    private Map<String,Integer> consumptionDetail;


}
