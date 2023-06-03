package com.banquemisr.autoirrigationservice.service;

import com.banquemisr.autoirrigationservice.dao.PlotSlotDao;
import com.banquemisr.autoirrigationservice.dto.PlotSlotDto;
import com.banquemisr.autoirrigationservice.model.PlotSlot;
import com.banquemisr.autoirrigationservice.transformer.PlotSlotTransformer;

public interface PlotSlotService extends BaseService<PlotSlot, PlotSlotDto, PlotSlotTransformer, PlotSlotDao> {
}
