package com.example.apartment.service.impl;

import com.example.apartment.converter.ApartmentConverter;
import com.example.apartment.dto.ApartmentDTO;
import com.example.apartment.model.*;
import com.example.apartment.repository.*;
import com.example.apartment.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private LoaiCanRepository loaiCanRepository;

    @Autowired
    private ApartmentConverter apartmentConverter;

    @Autowired
    private HopDongRepository hopDongRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public Optional<ApartmentDTO> getApartment(String maCan) {
        return apartmentRepository.findByMaCan(maCan).map(apartmentConverter::toDTO);
    }

    @Override
    public List<ApartmentDTO> getAllCan() {
        List<Can> can = apartmentRepository.findAll();
        return can.stream()
                .map(apartment -> apartmentConverter.toDTO(apartment))
                .collect(Collectors.toList());
    }

    @Override
    public void updateApartment(ApartmentDTO apartmentDTO) {
        Can aparment = apartmentRepository.findByMaCan(apartmentDTO.getMaCan()).orElseThrow();
        Location location = aparment.getChungCu().getLocation();
        if(location == null){
            location = new Location();
        }
        if(apartmentDTO.getDiaChi() != null) {
            location.setDiaChi(apartmentDTO.getDiaChi());
        }
        if(apartmentDTO.getTenViTri() != null) {
            location.setTenViTri(apartmentDTO.getTenViTri());
        }
        if(apartmentDTO.getMoTa() != null) {
            location.setMoTa(apartmentDTO.getMoTa());
        }
        locationRepository.save(location);

        LoaiCan loaiCan = aparment.getLoaiCan();
        if(loaiCan == null){
            loaiCan = new LoaiCan();
        }
        loaiCan.setDienTich(apartmentDTO.getDienTich());
        loaiCan.setGiaThueCoban(apartmentDTO.getGiaThue());
        loaiCan.setSoPhong(apartmentDTO.getSoPhong());
        loaiCanRepository.save(loaiCan);

        List<Don> currentDons = aparment.getDons();
        for(int i = 0; i<currentDons.size() ; i++){
            Don don =currentDons.get(i);
            Don donDTO = apartmentDTO.getDons().get(i);
            don.setNgayTao(donDTO.getNgayTao());
            don.setTrangThai(donDTO.getTrangThai());
            if(donDTO.getNguoiTao()!=null){
                TaiKhoan taiKhoan = don.getNguoiTao();

                if(taiKhoan == null) {
                    taiKhoan = new TaiKhoan();
                    don.setNguoiTao(taiKhoan);
                }
                if(apartmentDTO.getHoTen() != null) {
                    taiKhoan.setHoTen(apartmentDTO.getHoTen());
                }
                if(apartmentDTO.getEmail() != null) {
                    taiKhoan.setEmail(apartmentDTO.getEmail());
                }
                if(apartmentDTO.getSdt() != null) {
                    taiKhoan.setSdt(apartmentDTO.getSdt());
                }

                userRepository.save(taiKhoan);
            }
            hopDongRepository.save(don);
        }
        aparment.setTinhTrang(apartmentDTO.getTinhTrang());
        apartmentRepository.save(aparment);
    }

}
