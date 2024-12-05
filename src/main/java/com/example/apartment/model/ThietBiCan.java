package com.example.apartment.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "thietbi_can")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThietBiCan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long thietBiCanId;

    private LocalDate ngayLap;
    private String tinhTrang;
    private String ghiChu;

    @ManyToOne
    @JoinColumn(name = "can_id")
    private Can can;

    @ManyToOne
    @JoinColumn(name = "thietbi_id")
    private ThietBi thietBi;
}
