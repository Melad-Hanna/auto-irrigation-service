package com.banquemisr.autoirrigationservice.dao;

import com.banquemisr.autoirrigationservice.dao.repo.PlotCropRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PlotCropDaoImpl implements PlotCropDao {
    private final PlotCropRepo plotCropRepo;

    @Override
    public PlotCropRepo getRepository() {
        return plotCropRepo;
    }
}
