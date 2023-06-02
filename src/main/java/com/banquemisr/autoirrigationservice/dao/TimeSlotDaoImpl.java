package com.banquemisr.autoirrigationservice.dao;

import com.banquemisr.autoirrigationservice.dao.repo.TimeSlotRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TimeSlotDaoImpl implements TimeSlotDao {
    private TimeSlotRepo timeSlotRepo;

    @Override
    public TimeSlotRepo getRepository() {
        return timeSlotRepo;
    }
}
