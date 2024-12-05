package com.example.apartment.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "location")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    private String tenViTri;
    private String diaChi;
    private String moTa;

    @OneToMany(mappedBy = "location")
    private List<ChungCu> chungCus;
}