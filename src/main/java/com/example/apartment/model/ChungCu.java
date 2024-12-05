package com.example.apartment.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "chungcu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChungCu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chungCuId;

    private String tenChungCu;
    private Integer soTang;
    private Integer namXayDung;
    private String moTa;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "chungCu")
    private List<Can> cans;
}