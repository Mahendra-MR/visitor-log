package com.example.visitorlog.repository;

import com.example.visitorlog.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
    List<Visitor> findByCheckOutTimeIsNull();  // To get only active visitors
}
