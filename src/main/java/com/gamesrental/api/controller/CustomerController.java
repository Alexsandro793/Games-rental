package com.gamesrental.api.controller;

import com.gamesrental.api.model.dto.request.CustomerRequestDTO;
import com.gamesrental.api.model.dto.response.CustomerResponseDTO;
import com.gamesrental.api.service.customer.CustomerServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServiceImpl service;

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> getAll() {
        List<CustomerResponseDTO> customers = service.findAll();

        if (customers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> getById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> create(@Valid @RequestBody CustomerRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

}
