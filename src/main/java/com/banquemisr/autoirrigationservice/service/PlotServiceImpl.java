package com.banquemisr.autoirrigationservice.service;

import com.banquemisr.autoirrigationservice.dao.PlotDao;
import com.banquemisr.autoirrigationservice.transformer.PlotTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class PlotServiceImpl implements PlotService {
    private final PlotDao plotDao;
    private final PlotTransformer plotTransformer;

    @Override
    public PlotTransformer getTransformer() {
        return plotTransformer;
    }

    @Override
    public PlotDao getDao() {
        return plotDao;
    }
}
