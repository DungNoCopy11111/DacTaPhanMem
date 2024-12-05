package com.example.apartment.service;

import com.example.apartment.model.Can;
import com.example.apartment.model.Don;

import java.util.List;
import java.util.Optional;

public interface HopDongService {
    Optional<Don> findByCan(Can can);
    List<Don> findByCanId(Long canId);
}
