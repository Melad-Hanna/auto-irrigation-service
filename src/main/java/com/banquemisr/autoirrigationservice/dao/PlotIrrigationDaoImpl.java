package com.banquemisr.autoirrigationservice.dao;

import com.banquemisr.autoirrigationservice.dao.repo.PlotIrrigationRepo;
import com.banquemisr.autoirrigationservice.dao.repo.PlotRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PlotIrrigationDaoImpl implements PlotIrrigationDao {
    private final PlotIrrigationRepo plotIrrigationRepo;

    @Override
    public PlotIrrigationRepo getRepository() {
        return plotIrrigationRepo;
    }
}
