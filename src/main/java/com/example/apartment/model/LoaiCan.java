package com.example.apartment.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "loaican")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoaiCan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loaiCanId;

    private String tenLoai;
    private Float dienTich;
    private Integer soPhong;
    private BigDecimal giaThueCoban;
    private String moTa;

    @OneToMany(mappedBy = "loaiCan")
    private List<Can> cans;
}