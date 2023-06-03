package com.banquemisr.autoirrigationservice.service;

import com.banquemisr.autoirrigationservice.dao.PlotSlotDao;
import com.banquemisr.autoirrigationservice.transformer.PlotSlotTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlotSlotServiceImpl implements PlotSlotService {
    private final PlotSlotDao plotSlotDao;
    private final PlotSlotTransformer plotSlotTransformer;

    @Override
    public PlotSlotTransformer getTransformer() {
        return plotSlotTransformer;
    }

    @Override
    public PlotSlotDao getDao() {
        return plotSlotDao;
    }
}
