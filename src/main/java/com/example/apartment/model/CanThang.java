package com.example.apartment.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "canthang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CanThang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long canThangId;

    private Integer thang;
    private Integer nam;
    private String tinhTrangThue;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private BigDecimal giaThue;
    private Boolean daThanhToan;
    private LocalDate ngayThanhToan;
    private String ghiChu;

    @ManyToOne
    @JoinColumn(name = "can_id")
    private Can can;
}
