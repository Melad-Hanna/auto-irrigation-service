package com.banquemisr.autoirrigationservice.dao.repo;

import com.banquemisr.autoirrigationservice.model.PlotSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlotSlotRepo extends JpaRepository<PlotSlot, Long> {
}
