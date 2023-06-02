package com.banquemisr.autoirrigationservice.service;

import com.banquemisr.autoirrigationservice.dao.TimeSlotDao;
import com.banquemisr.autoirrigationservice.transformer.TimeSlotTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TimeSlotServiceImpl implements TimeSlotService {
    private TimeSlotTransformer timeSlotTransformer;
    private TimeSlotDao timeSlotDao;

    @Override
    public TimeSlotTransformer getTransformer() {
        return timeSlotTransformer;
    }

    @Override
    public TimeSlotDao getDao() {
        return timeSlotDao;
    }
}
