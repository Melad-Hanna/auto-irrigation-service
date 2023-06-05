package com.banquemisr.autoirrigationservice.service;

import com.banquemisr.autoirrigationservice.dao.PlotSlotDao;
import com.banquemisr.autoirrigationservice.dto.PlotSlotDto;
import com.banquemisr.autoirrigationservice.model.PlotSlot;
import com.banquemisr.autoirrigationservice.transformer.PlotSlotTransformer;
import java.util.List;
import java.util.Set;

public interface PlotSlotService extends BaseService<PlotSlot, PlotSlotDto, PlotSlotTransformer, PlotSlotDao> {
    List<PlotSlotDto> updatePlotSlots(Long plotId, Set<PlotSlotDto> plotSlotDtos);
}
