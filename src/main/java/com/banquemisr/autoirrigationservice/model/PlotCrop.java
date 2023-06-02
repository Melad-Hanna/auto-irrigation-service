package com.banquemisr.autoirrigationservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "plot_config")
public class PlotCrop extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plot_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Plot plot;

    @Column(name = "plot_id", insertable = false, updatable = false)
    private Long plotId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crop_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Crop crop;

    @Column(name = "crop_id", insertable = false, updatable = false)
    private Long cropId;
}
