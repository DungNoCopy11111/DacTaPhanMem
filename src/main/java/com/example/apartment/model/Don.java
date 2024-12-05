package com.example.apartment.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "don")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Don {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long donId;

    private Integer thuTu;
    private String loaiDon;
    private LocalDate ngayTao;

    private String trangThai;

    @ManyToOne
    @JoinColumn(name = "can_id")
    private Can can;

    @ManyToOne
    @JoinColumn(name = "nguoitao_id")
    private TaiKhoan nguoiTao;
}