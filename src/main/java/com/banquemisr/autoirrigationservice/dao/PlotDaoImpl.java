package com.banquemisr.autoirrigationservice.dao;

import com.banquemisr.autoirrigationservice.dao.repo.PlotRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PlotDaoImpl implements PlotDao {
    private final PlotRepo plotRepo;

    @Override
    public PlotRepo getRepository() {
        return plotRepo;
    }
}
