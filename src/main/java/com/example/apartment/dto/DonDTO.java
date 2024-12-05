package com.example.apartment.dto;

import com.example.apartment.model.TaiKhoan;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DonDTO {
    private LocalDate ngayBatDau;
    private String trangThai;
    private TaiKhoan nguoiTao;
}
