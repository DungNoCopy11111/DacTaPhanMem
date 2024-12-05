package com.example.apartment.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "can")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Can {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long canId;

    private String maCan;
    private Integer tang;
    private String tinhTrang;

    @ManyToOne
    @JoinColumn(name = "chungcu_id")
    private ChungCu chungCu;

    @ManyToOne
    @JoinColumn(name = "loaican_id")
    private LoaiCan loaiCan;

    @OneToMany(mappedBy = "can")
    private List<CanThang> canThangs;

    @OneToMany(mappedBy = "can")
    private List<ThietBiCan> thietBiCans;

    @OneToMany(mappedBy = "can")
    private List<Don> dons;
}