package com.banquemisr.autoirrigationservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlotCropDto extends BaseDto {
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long plotId;

    private CropDto crop;
    @NotNull(message = "this field is required")
    private Long cropId;

    @Valid
    @NotNull(message = "this field is required")
    private List<PlotSlotDto> plotSlots;
}
