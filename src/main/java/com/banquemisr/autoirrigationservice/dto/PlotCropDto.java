package com.banquemisr.autoirrigationservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.core.util.Json;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlotCropDto extends BaseDto {
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long plotId;

    private CropDto crop;
    @NotNull(message = "this field is required")
    private Long cropId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Set<PlotSlotDto> plotSlots = new HashSet<>();
}
