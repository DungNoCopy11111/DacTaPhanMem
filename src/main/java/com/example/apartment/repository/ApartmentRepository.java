package com.example.apartment.repository;

import com.example.apartment.model.Can;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApartmentRepository extends JpaRepository<Can,String> {
    Optional<Can> findByMaCan(String maCan);
}
