package com.example.apartment.service.impl;

import com.example.apartment.exception.ResourceNotFoundException;
import com.example.apartment.model.ThietBi;
import com.example.apartment.repository.DeviceRepository;
import com.example.apartment.service.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService {
    private static final Logger log = LoggerFactory.getLogger(DeviceServiceImpl.class);
    @Autowired
    private DeviceRepository deviceRepository;
    @Override
    public List<ThietBi> getAllThietBi() {
        return deviceRepository.findAll();
    }

    @Override
    public Optional<ThietBi> getThietBiById(Long id) {
        return deviceRepository.findById(id);
    }

    @Override
    public void update(ThietBi thietBi) {
        ThietBi device = deviceRepository.findById(thietBi.getThietBiId())
                .orElseThrow(() -> new ResourceNotFoundException("ThietBi", "id", thietBi.getThietBiId()));
        device.setTenThietBi(thietBi.getTenThietBi());
        device.setLoaiThietBi(thietBi.getLoaiThietBi());
        device.setNhaSanXuat(thietBi.getNhaSanXuat());
        device.setMoTa(thietBi.getMoTa());
        device.setGiaMua(thietBi.getGiaMua());
        device.setNgayMua(thietBi.getNgayMua());
        device.setTinhTrang(thietBi.getTinhTrang());
        device.setThoiGianBaoHanh(thietBi.getThoiGianBaoHanh());
        device.setNhaCungCap(thietBi.getNhaCungCap());
        log.info("ThietBi : {}", thietBi);
        deviceRepository.save(device);
    }
}
