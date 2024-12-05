package com.example.apartment.service;

import com.example.apartment.model.ThietBi;

import java.util.List;
import java.util.Optional;

public interface DeviceService {
    List<ThietBi> getAllThietBi();
    Optional<ThietBi> getThietBiById(Long id);
    void update(ThietBi thietBi);
}
