package com.example.apartment.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "thietbi")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThietBi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long thietBiId;

    private String tenThietBi;
    private String loaiThietBi;
    private String nhaSanXuat;
    private String moTa;

    @Column(precision = 10, scale = 2)
    private BigDecimal giaMua;

    private LocalDate ngayMua;
    private String tinhTrang;
    private Integer thoiGianBaoHanh;
    private String nhaCungCap;

    @OneToMany(mappedBy = "thietBi")
    private List<ThietBiCan> thietBiCans;
}