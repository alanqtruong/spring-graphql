package com.example.spring.graph.ql.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class StatusController {

    private static final ResponseEntity<String> STATUS = new ResponseEntity<>("OK", HttpStatus.OK);

    @GetMapping("/status")
    public ResponseEntity<String> checkHealth() {
        return STATUS;
    }
}
