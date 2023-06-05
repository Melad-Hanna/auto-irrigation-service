package com.banquemisr.autoirrigationservice.service;

import com.banquemisr.autoirrigationservice.dao.CropDao;
import com.banquemisr.autoirrigationservice.transformer.CropTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CropServiceImpl implements CropService {
    private final CropTransformer cropTransformer;
    private final CropDao cropDao;

    @Override
    public CropTransformer getTransformer() {
        return cropTransformer;
    }

    @Override
    public CropDao getDao() {
        return cropDao;
    }
}
