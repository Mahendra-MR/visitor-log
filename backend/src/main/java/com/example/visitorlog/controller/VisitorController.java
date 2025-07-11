package com.example.visitorlog.controller;

import com.example.visitorlog.model.Visitor;
import com.example.visitorlog.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    @Autowired
    private VisitorRepository visitorRepository;

    // ✅ 1. Check-in a new visitor
    @PostMapping
    public Visitor checkInVisitor(@RequestBody Visitor visitor) {
        visitor.setCheckInTime(LocalDateTime.now());
        return visitorRepository.save(visitor);
    }

    // ✅ 2. Check-out a visitor
    @PutMapping("/{id}/checkout")
    public Visitor checkOutVisitor(@PathVariable Long id) {
        Visitor visitor = visitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));
        visitor.setCheckOutTime(LocalDateTime.now());
        return visitorRepository.save(visitor);
    }

    // ✅ 3. Get all active visitors (not checked out)
    @GetMapping("/active")
    public List<Visitor> getActiveVisitors() {
        return visitorRepository.findByCheckOutTimeIsNull();
    }

    // ✅ 4. Get all visitors
    @GetMapping
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }
}
