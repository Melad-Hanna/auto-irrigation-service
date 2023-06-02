package com.banquemisr.autoirrigationservice.dao;

import com.banquemisr.autoirrigationservice.dao.repo.CropRepo;
import com.banquemisr.autoirrigationservice.dao.repo.PlotRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CropDaoImpl implements CropDao {
    private final CropRepo plotRepo;

    @Override
    public CropRepo getRepository() {
        return plotRepo;
    }
}
