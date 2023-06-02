package com.banquemisr.autoirrigationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseDto {
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private Boolean markedAsDeleted = false;
}
