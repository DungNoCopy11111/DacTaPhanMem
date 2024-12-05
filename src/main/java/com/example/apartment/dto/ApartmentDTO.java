package com.example.apartment.dto;

import com.example.apartment.model.Don;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class ApartmentDTO {
    @NotBlank(message = "Địa chỉ không được để trống")
    private String diaChi;

    private String moTa;

    @NotBlank(message = "Tên vị trí không được để trống")
    private String tenViTri;

    private String loaiCan;

    // Thông tin căn hộ
    @NotBlank(message = "Mã căn hộ không được để trống")
    private String maCan;

    @NotNull
    private List<Don> dons;


    private String tinhTrang;


    @NotNull(message = "Diện tích không được để trống")
    @Positive(message = "Diện tích phải lớn hơn 0")
    private Float dienTich;

    @NotNull(message = "Giá thuê không được để trống")
    @PositiveOrZero(message = "Giá thuê không được âm")
    private BigDecimal giaThue;

    @NotNull(message = "Số phòng không được để trống")
    @Min(value = 1, message = "Số phòng phải lớn hơn hoặc bằng 1")
    private Integer soPhong;

    // Thông tin người thuê
    @NotBlank(message = "Họ tên không được để trống")
    private String hoTen;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    private String email;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})\\b", message = "Số điện thoại không hợp lệ")
    private String sdt;

    private LocalDate ngayBatDau;

    private String trangThai;

}
