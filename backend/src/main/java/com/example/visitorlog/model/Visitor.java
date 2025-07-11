package com.example.visitorlog.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String purpose;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
}
