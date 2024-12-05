package com.example.apartment.service;

import com.example.apartment.dto.ApartmentDTO;
import com.example.apartment.model.Can;
import com.example.apartment.model.Location;

import java.util.List;
import java.util.Optional;

public interface ApartmentService {
    Optional<ApartmentDTO> getApartment(String id);
    List<ApartmentDTO> getAllCan();
    void updateApartment(ApartmentDTO apartmentDTO);
}
