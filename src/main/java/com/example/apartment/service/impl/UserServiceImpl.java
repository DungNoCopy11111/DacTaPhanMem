package com.example.apartment.service.impl;

import com.example.apartment.model.TaiKhoan;
import com.example.apartment.repository.UserRepository;
import com.example.apartment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Optional<TaiKhoan> login(String tenDangNhap, String matKhau) {
        return userRepository.findByTenDangNhap(tenDangNhap)
                .filter(taiKhoan -> taiKhoan.getMatKhau().equals(matKhau));
    }
}
