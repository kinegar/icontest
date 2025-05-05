package com.kinegar.icontest.model.extmodel;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingList {
    private LocalDateTime bookingDate;
    private String officeName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Consumption> listConsumption;
    private Integer participants;
    private String roomName;
    private String id;

}
