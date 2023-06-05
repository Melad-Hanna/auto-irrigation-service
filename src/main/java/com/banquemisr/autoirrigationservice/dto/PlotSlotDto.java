package com.banquemisr.autoirrigationservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlotSlotDto extends BaseDto {

    @EqualsAndHashCode.Exclude
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long plotCropId;

    @EqualsAndHashCode.Exclude
    private TimeSlotDto timeSlot;

    @NotNull(message = "this field is required")
    private Long timeSlotId;

    @NotNull(message = "this field is required")
    @Min(value = 1, message = "min. value is 1 litre")
    @EqualsAndHashCode.Exclude
    private Integer waterLiterAmount;
}
