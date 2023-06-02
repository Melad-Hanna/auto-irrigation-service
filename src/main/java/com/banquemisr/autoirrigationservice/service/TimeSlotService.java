package com.banquemisr.autoirrigationservice.service;

import com.banquemisr.autoirrigationservice.dao.TimeSlotDao;
import com.banquemisr.autoirrigationservice.dto.TimeSlotDto;
import com.banquemisr.autoirrigationservice.model.TimeSlot;
import com.banquemisr.autoirrigationservice.transformer.TimeSlotTransformer;

public interface TimeSlotService extends BaseService<TimeSlot, TimeSlotDto, TimeSlotTransformer, TimeSlotDao> {
}
