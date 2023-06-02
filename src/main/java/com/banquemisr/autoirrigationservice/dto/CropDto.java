package com.banquemisr.autoirrigationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CropDto extends BaseDto {
    private Long id;

    @NotNull(message = "this field is required")
    private String label;
}
