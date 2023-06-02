package com.banquemisr.autoirrigationservice.dao;

import com.banquemisr.autoirrigationservice.dao.repo.CropRepo;
import com.banquemisr.autoirrigationservice.dao.repo.PlotRepo;
import com.banquemisr.autoirrigationservice.model.Crop;
import com.banquemisr.autoirrigationservice.model.Plot;

public interface CropDao extends BaseDao<Crop, CropRepo> {
}
