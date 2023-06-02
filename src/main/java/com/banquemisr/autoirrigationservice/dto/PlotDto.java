package com.banquemisr.autoirrigationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlotDto extends BaseDto {
    private Long id;

    @NotNull(message = "this field is required")
    private String label;

    @NotNull(message = "this field is required")
    @DecimalMin(value = "1", message = "min. area value is 1")
    private BigDecimal area;
}
