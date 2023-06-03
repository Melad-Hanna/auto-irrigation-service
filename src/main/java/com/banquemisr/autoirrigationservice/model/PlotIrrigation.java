package com.banquemisr.autoirrigationservice.model;


import com.banquemisr.autoirrigationservice.enums.PlotIrrigationStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "plot_irrigation")
public class PlotIrrigation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plot_slot_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private PlotSlot plotSlot;

    @Column(name = "plot_slot_id", insertable = false, updatable = false)
    private Long plotSlotId;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private PlotIrrigationStatus status;
}
