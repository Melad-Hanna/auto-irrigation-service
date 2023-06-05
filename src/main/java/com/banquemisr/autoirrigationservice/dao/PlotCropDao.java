package com.banquemisr.autoirrigationservice.dao;

import com.banquemisr.autoirrigationservice.dao.repo.PlotCropRepo;
import com.banquemisr.autoirrigationservice.model.PlotCrop;

import java.util.Optional;

public interface PlotCropDao extends BaseDao<PlotCrop, PlotCropRepo> {
    Optional<PlotCrop> findByPlotId(Long plotId);
}
