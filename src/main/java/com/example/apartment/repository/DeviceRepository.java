package com.example.apartment.repository;

import com.example.apartment.model.ThietBi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<ThietBi,Long> {
}
