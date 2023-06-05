package com.banquemisr.autoirrigationservice.dao;

import com.banquemisr.autoirrigationservice.dao.repo.PlotCropRepo;
import com.banquemisr.autoirrigationservice.model.PlotCrop;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class PlotCropDaoImpl implements PlotCropDao {
    private final PlotCropRepo plotCropRepo;

    @Override
    public PlotCropRepo getRepository() {
        return plotCropRepo;
    }

    @Override
    public Optional<PlotCrop> findByPlotId(Long plotId) {
        return getRepository().findByPlotIdAndMarkedAsDeletedFalse(plotId);
    }
}
