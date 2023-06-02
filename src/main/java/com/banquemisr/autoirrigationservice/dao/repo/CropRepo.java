package com.banquemisr.autoirrigationservice.dao.repo;

import com.banquemisr.autoirrigationservice.model.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepo extends JpaRepository<Crop, Long> {
}
