package com.example.apartment.service.impl;

import com.example.apartment.model.Can;
import com.example.apartment.model.Don;
import com.example.apartment.repository.HopDongRepository;
import com.example.apartment.service.HopDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HopDongServiceImpl implements HopDongService {
    @Autowired
    private HopDongRepository hopDongRepository;
    @Override
    public Optional<Don> findByCan(Can can) {
        return hopDongRepository.findByCan(can);
    }

    @Override
    public List<Don> findByCanId(Long canId) {
        return hopDongRepository.findByCanId(canId);
    }
}
