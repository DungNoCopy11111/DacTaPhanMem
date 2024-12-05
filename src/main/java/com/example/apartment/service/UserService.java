package com.example.apartment.service;

import com.example.apartment.model.TaiKhoan;

import java.util.Optional;

public interface UserService {
    Optional<TaiKhoan> login(String tenDangNhap, String matKhau);
}
