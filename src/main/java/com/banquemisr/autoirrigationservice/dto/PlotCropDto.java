package com.banquemisr.autoirrigationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlotCropDto extends BaseDto {
    private Long id;

    private PlotDto plot;
    @NotNull(message = "this field is required")
    private Long plotId;

    private CropDto crop;
    @NotNull(message = "this field is required")
    private Long cropId;
}
