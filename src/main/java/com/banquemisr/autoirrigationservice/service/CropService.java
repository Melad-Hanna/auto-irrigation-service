package com.banquemisr.autoirrigationservice.service;

import com.banquemisr.autoirrigationservice.dao.CropDao;
import com.banquemisr.autoirrigationservice.dto.CropDto;
import com.banquemisr.autoirrigationservice.model.Crop;
import com.banquemisr.autoirrigationservice.transformer.CropTransformer;

public interface CropService extends BaseService<Crop, CropDto, CropTransformer, CropDao> {
}
