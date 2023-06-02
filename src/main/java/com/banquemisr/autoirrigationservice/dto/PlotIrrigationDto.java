package com.banquemisr.autoirrigationservice.dto;


import com.banquemisr.autoirrigationservice.enums.PlotIrrigationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlotIrrigationDto extends BaseDto {
    private Long id;

    private PlotConfigDto plotTimeSlot;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private PlotIrrigationStatus status;
}
