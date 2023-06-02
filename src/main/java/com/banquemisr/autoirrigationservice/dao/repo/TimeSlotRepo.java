package com.banquemisr.autoirrigationservice.dao.repo;

import com.banquemisr.autoirrigationservice.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSlotRepo extends JpaRepository<TimeSlot, Long> {
}
