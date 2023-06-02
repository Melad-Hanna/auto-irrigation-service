package com.banquemisr.autoirrigationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlotConfigDto extends BaseDto {

    private Long id;

    private PlotCropDto plotCrop;
    @NotNull(message = "this field is required")
    private Long plotCropId;

    private TimeSlotDto timeSlot;
    @NotNull(message = "this field is required")
    private Long timeSlotId;

    @NotNull(message = "this field is required")
    @Min(value = 1, message = "min. value is 1 litre")
    private Integer waterLiterAmount;
}
