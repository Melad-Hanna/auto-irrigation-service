package com.banquemisr.autoirrigationservice.service;

import com.banquemisr.autoirrigationservice.dao.PlotConfigDao;
import com.banquemisr.autoirrigationservice.dto.PlotConfigDto;
import com.banquemisr.autoirrigationservice.model.PlotConfig;
import com.banquemisr.autoirrigationservice.transformer.PlotConfigTransformer;

public interface PlotConfigService extends BaseService<PlotConfig, PlotConfigDto, PlotConfigTransformer, PlotConfigDao> {
}
