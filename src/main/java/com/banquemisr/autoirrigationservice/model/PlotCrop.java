package com.banquemisr.autoirrigationservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.MERGE;

@NoArgsConstructor
@Data
@Entity
@Table(name = "plot_crop")
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

    @OneToMany(mappedBy = "plotCrop", cascade = MERGE, fetch = FetchType.LAZY)
    @Where(clause = "marked_as_deleted = false")
    private Set<PlotSlot> plotSlots;
}
