package com.banquemisr.autoirrigationservice.dao.repo;

import com.banquemisr.autoirrigationservice.model.Plot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlotRepo extends JpaRepository<Plot, Long> {
}
