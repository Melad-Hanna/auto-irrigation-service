package com.banquemisr.autoirrigationservice.service;

import com.banquemisr.autoirrigationservice.dao.PlotDao;
import com.banquemisr.autoirrigationservice.dto.PlotDto;
import com.banquemisr.autoirrigationservice.model.Plot;
import com.banquemisr.autoirrigationservice.transformer.PlotTransformer;

public interface PlotService extends BaseService<Plot, PlotDto, PlotTransformer, PlotDao> {
}
