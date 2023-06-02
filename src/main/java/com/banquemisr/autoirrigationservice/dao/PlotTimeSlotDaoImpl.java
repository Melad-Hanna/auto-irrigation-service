package com.banquemisr.autoirrigationservice.dao;

import com.banquemisr.autoirrigationservice.dao.repo.PlotConfigRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PlotTimeSlotDaoImpl implements PlotTimeSlotDao {
    private final PlotConfigRepo plotConfigRepo;

    @Override
    public PlotConfigRepo getRepository() {
        return plotConfigRepo;
    }
}
