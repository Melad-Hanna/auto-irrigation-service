package com.banquemisr.autoirrigationservice.dao.repo;

import com.banquemisr.autoirrigationservice.model.Plot;
import com.banquemisr.autoirrigationservice.model.PlotIrrigation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlotIrrigationRepo extends JpaRepository<PlotIrrigation, Long> {
}
