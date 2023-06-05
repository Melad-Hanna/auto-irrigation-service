package com.banquemisr.autoirrigationservice.dao.repo;

import com.banquemisr.autoirrigationservice.model.PlotCrop;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlotCropRepo extends JpaRepository<PlotCrop, Long> {
    @EntityGraph(
            type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {
                    "plotSlots"
            }
    )
    Optional<PlotCrop> findByPlotIdAndMarkedAsDeletedFalse(Long plotId);
}
