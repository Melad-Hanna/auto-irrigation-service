package com.banquemisr.autoirrigationservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "plot_slot")
public class PlotSlot extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plot_crop_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private PlotCrop plotCrop;

    @Column(name = "plot_crop_id", insertable = false, updatable = false)
    private Long plotCropId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "time_slot_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private TimeSlot timeSlot;

    @Column(name = "time_slot_id", insertable = false, updatable = false)
    private Long timeSlotId;

    @Column(name = "water_liter_amount")
    private Integer waterLiterAmount;
}
