package com.example.apartment.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "taikhoan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taiKhoanId;

    @Column(unique = true)
    private String tenDangNhap;
    private String matKhau;
    private String hoTen;
    private String email;
    private String sdt;
    private String vaiTro;
    private Boolean trangThai;

    @OneToMany(mappedBy = "nguoiTao")
    private List<Don> dons;
}