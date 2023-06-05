package com.banquemisr.autoirrigationservice.service;

import com.banquemisr.autoirrigationservice.dao.PlotCropDao;
import com.banquemisr.autoirrigationservice.dto.PlotCropDto;
import com.banquemisr.autoirrigationservice.model.PlotCrop;
import com.banquemisr.autoirrigationservice.transformer.PlotCropTransformer;

import java.util.Optional;

public interface PLotCropService extends BaseService<PlotCrop, PlotCropDto, PlotCropTransformer, PlotCropDao> {

    PlotCropDto updatePlotCrop(Long plotId, PlotCropDto plotCropDto);

    Optional<PlotCropDto> findByPlotId(Long plotId);
}
