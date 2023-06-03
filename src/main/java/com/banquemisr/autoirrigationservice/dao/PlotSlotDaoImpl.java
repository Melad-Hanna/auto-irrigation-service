package com.banquemisr.autoirrigationservice.dao;

import com.banquemisr.autoirrigationservice.dao.repo.PlotSlotRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PlotSlotDaoImpl implements PlotSlotDao {
    private final PlotSlotRepo plotSlotRepo;

    @Override
    public PlotSlotRepo getRepository() {
        return plotSlotRepo;
    }
}
