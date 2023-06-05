package com.banquemisr.autoirrigationservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlotDto extends BaseDto {
    private Long id;

    @NotNull(message = "this field is required")
    private String label;

    @NotNull(message = "this field is required")
    @DecimalMin(value = "1", message = "min. area value is 1")
    private BigDecimal area;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private PlotCropDto plotCrop;
}
