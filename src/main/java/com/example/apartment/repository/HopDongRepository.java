package com.example.apartment.repository;

import com.example.apartment.model.Can;
import com.example.apartment.model.Don;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HopDongRepository extends JpaRepository<Don,Long> {
    Optional<Don> findByCan(Can can);
    @Query("SELECT d FROM Don d WHERE d.can.canId = :canId")
    List<Don> findByCanId(@Param("canId") Long canId);
}
