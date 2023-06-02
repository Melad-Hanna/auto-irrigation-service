package com.banquemisr.autoirrigationservice.dto;

import com.banquemisr.autoirrigationservice.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TimeSlotDto extends BaseDto {
    private Long id;
    private LocalTime time;
    private boolean isActive;
}
