package com.banquemisr.autoirrigationservice.service;

import com.banquemisr.autoirrigationservice.dao.PlotConfigDao;
import com.banquemisr.autoirrigationservice.dao.PlotDao;
import com.banquemisr.autoirrigationservice.transformer.PlotConfigTransformer;
import com.banquemisr.autoirrigationservice.transformer.PlotTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlotConfigServiceImpl implements PlotConfigService {
    private final PlotConfigDao plotConfigDao;
    private final PlotConfigTransformer plotConfigTransformer;

    @Override
    public PlotConfigTransformer getTransformer() {
        return plotConfigTransformer;
    }

    @Override
    public PlotConfigDao getDao() {
        return plotConfigDao;
    }
}
