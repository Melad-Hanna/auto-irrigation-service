package com.banquemisr.autoirrigationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseDto {
    @EqualsAndHashCode.Exclude
    private LocalDateTime createdDate;

    @EqualsAndHashCode.Exclude
    private LocalDateTime modifiedDate;

    @EqualsAndHashCode.Exclude
    private Boolean markedAsDeleted = false;
}
