package com.banquemisr.autoirrigationservice.service;

import com.banquemisr.autoirrigationservice.AutoIrrigationServiceApplication;
import com.banquemisr.autoirrigationservice.dao.PlotDao;
import com.banquemisr.autoirrigationservice.dto.PlotDto;
import com.banquemisr.autoirrigationservice.model.Plot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {AutoIrrigationServiceApplication.class})
public class PlotServiceTests {

    @Autowired
    private PlotService plotService;

    @MockBean
    private PlotDao plotDao;


    @Test
    public void CreatePlot_InputPlotDto_OutputPlotDto() {
        // PREPARE
        PlotDto toBeCreatedPlotDto = new PlotDto();
        toBeCreatedPlotDto.setLabel("Plot 1");
        toBeCreatedPlotDto.setArea(new BigDecimal(200));

        Plot shouldBeCreatedPlot = plotService.getTransformer().transformDTOToEntity(toBeCreatedPlotDto);

        // MOCK
        when(plotService.getDao().create((Plot) any())).thenReturn(shouldBeCreatedPlot);
        // OR
        //        given(plotService.getDao().create((Plot) any())).willReturn(shouldBeCreatedPlot);

        // DO SHIT
        PlotDto plotDto = plotService.create(toBeCreatedPlotDto);
        assertInstanceOf(PlotDto.class, plotDto);
        assertEquals(shouldBeCreatedPlot.getLabel(), plotDto.getLabel());

        // VERIFY
        verify(plotDao, times(1)).create((Plot) any());
    }
}
