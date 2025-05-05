package com.kinegar.icontest.model.extmodel;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MasterJenisKonsumsi {
    private LocalDateTime createdAt;
    private String name;
    private BigDecimal maxPrice;
    private String id;
}
