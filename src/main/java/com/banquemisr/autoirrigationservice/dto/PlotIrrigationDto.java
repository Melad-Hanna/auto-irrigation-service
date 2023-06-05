package com.banquemisr.autoirrigationservice.dto;


import com.banquemisr.autoirrigationservice.enums.PlotIrrigationStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlotIrrigationDto extends BaseDto {
    private Long id;

    private PlotSlotDto plotSlot;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private PlotIrrigationStatus status;
}
