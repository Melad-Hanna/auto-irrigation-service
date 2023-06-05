package com.banquemisr.autoirrigationservice.service;

import com.banquemisr.autoirrigationservice.constant.MessagesConstants;
import com.banquemisr.autoirrigationservice.dao.PlotSlotDao;
import com.banquemisr.autoirrigationservice.dto.PlotCropDto;
import com.banquemisr.autoirrigationservice.dto.PlotSlotDto;
import com.banquemisr.autoirrigationservice.exception.custom.BusinessException;
import com.banquemisr.autoirrigationservice.transformer.PlotSlotTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class PlotSlotServiceImpl implements PlotSlotService {
    private final PlotSlotDao plotSlotDao;
    private final PlotSlotTransformer plotSlotTransformer;
    private final PLotCropService pLotCropService;
    private final TimeSlotService timeSlotService;

    @Override
    public PlotSlotTransformer getTransformer() {
        return plotSlotTransformer;
    }

    @Override
    public PlotSlotDao getDao() {
        return plotSlotDao;
    }

    @Override
    @Transactional
    public List<PlotSlotDto> updatePlotSlots(Long plotId, Set<PlotSlotDto> plotSlotDtos) {
        log.info("PlotSlotService updatePlotSlots(Long,Set<PlotSlotDto>)");
        PlotCropDto plotCropDto = pLotCropService.findByPlotId(plotId)
                .orElseThrow(() -> new BusinessException(MessagesConstants.ITEM_NOT_FOUND));
        plotSlotDtos.forEach(dto -> {
            dto.setPlotCropId(plotCropDto.getId());
            if (plotCropDto.getPlotSlots().contains(dto))
                // TODO: ERROR IN UPDATE
                update(dto, dto.getId());
            else create(plotCropDto.getId(), dto);
        });
        plotCropDto.getPlotSlots().stream().filter(dto -> !plotSlotDtos.contains(dto)).forEach(this::delete);
        return new ArrayList<>(plotSlotDtos);
    }

    private void create(Long plotCropId, PlotSlotDto toBeCreatedPlotSlot) {
        toBeCreatedPlotSlot.setPlotCropId(plotCropId);
        toBeCreatedPlotSlot.setTimeSlot(timeSlotService.findById(toBeCreatedPlotSlot.getTimeSlotId()));
        create(toBeCreatedPlotSlot);
    }

    private void delete(PlotSlotDto plotSlotDto) {
        plotSlotDto.setMarkedAsDeleted(true);
        update(plotSlotDto, plotSlotDto.getId());
    }
}
