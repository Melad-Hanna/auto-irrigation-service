package com.banquemisr.autoirrigationservice.service;

import com.banquemisr.autoirrigationservice.dao.PlotCropDao;
import com.banquemisr.autoirrigationservice.dto.PlotCropDto;
import com.banquemisr.autoirrigationservice.model.PlotCrop;
import com.banquemisr.autoirrigationservice.transformer.PlotCropTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class PlotCropServiceImpl implements PLotCropService {
    private final PlotCropTransformer plotCropTransformer;
    private final PlotCropDao plotCropDao;
    private final CropService cropService;
    private final PlotService plotService;

    @Override
    public PlotCrop doBeforeCreateEntity(PlotCrop entity, PlotCropDto dto) {
        entity.setPlot(plotService.findEntityById(dto.getPlotId()));
        entity.setCrop(cropService.findEntityById(dto.getCropId()));
        return entity;
    }

    @Override
    @Transactional
    public PlotCropDto updatePlotCrop(Long plotId, PlotCropDto plotCropDto) {
        log.info("PLotCropService: updatePlotCrop(Long,Long)");
        Optional<PlotCropDto> existingPlotCrop = findByPlotId(plotId);
        existingPlotCrop.ifPresent(this::delete);
        plotCropDto.setPlotId(plotId);
        return create(plotCropDto);
    }

    @Override
    public Optional<PlotCropDto> findByPlotId(Long plotId) {
        return Optional.ofNullable(getTransformer().transformEntityToDTO(getDao().findByPlotId(plotId).orElse(null)));
    }

    private void delete(PlotCropDto plotCropDto) {
        plotCropDto.setMarkedAsDeleted(true);
        update(plotCropDto, plotCropDto.getId());
    }

    @Override
    public PlotCropTransformer getTransformer() {
        return plotCropTransformer;
    }

    @Override
    public PlotCropDao getDao() {
        return plotCropDao;
    }
}
