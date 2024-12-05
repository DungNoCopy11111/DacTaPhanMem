package com.example.apartment.converter;

import com.example.apartment.dto.ApartmentDTO;
import com.example.apartment.model.Can;
import com.example.apartment.model.Don;
import com.example.apartment.model.Location;
import com.example.apartment.model.TaiKhoan;
import com.example.apartment.repository.HopDongRepository;
import com.example.apartment.service.HopDongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApartmentConverter {
    private final HopDongService hopDongService;

    public ApartmentDTO toDTO(Can can){
        Location location = can.getChungCu().getLocation();
        Don hopDong = hopDongService.findByCan(can).orElseThrow(() -> new RuntimeException("Không tìm thấy hợp đồng"));
        TaiKhoan taiKhoan = hopDong.getNguoiTao();
        return ApartmentDTO.builder().
                diaChi(location.getDiaChi()).
                moTa(location.getMoTa()).
                tenViTri(location.getTenViTri()).
                maCan(can.getMaCan()).
                dienTich(can.getLoaiCan().getDienTich()).
                giaThue(can.getLoaiCan().getGiaThueCoban()).
                soPhong(can.getLoaiCan().getSoPhong()).
                loaiCan(can.getLoaiCan().getTenLoai()).
                hoTen(taiKhoan.getHoTen()).
                email(taiKhoan.getEmail()).
                sdt(taiKhoan.getSdt()).
                tinhTrang(can.getTinhTrang()).
                dons(can.getDons()).
                ngayBatDau(hopDong.getNgayTao()).
                trangThai(hopDong.getTrangThai()).
                build();
    }
}
