package com.example.visitorlog.controller;

import com.example.visitorlog.model.Visitor;
import com.example.visitorlog.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/export")
public class ExportController {

    @Autowired
    private VisitorRepository visitorRepository;

    @GetMapping("/visitors")
    public void exportVisitors(HttpServletResponse response) throws Exception {
        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=visitors.csv");

        List<Visitor> visitors = visitorRepository.findAll();
        PrintWriter writer = response.getWriter();

        writer.println("ID,Name,Phone,Purpose,CheckIn,CheckOut");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (Visitor v : visitors) {
            writer.printf("%d,%s,%s,%s,%s,%s\n",
                v.getId(),
                v.getName(),
                v.getPhone(),
                v.getPurpose(),
                v.getCheckInTime() != null ? v.getCheckInTime().format(formatter) : "",
                v.getCheckOutTime() != null ? v.getCheckOutTime().format(formatter) : ""
            );
        }

        writer.flush();
        writer.close();
    }
}
