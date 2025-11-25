package com.gamesrental.api.interfaces;

import com.gamesrental.api.model.dto.request.CustomerRequestDTO;
import com.gamesrental.api.model.dto.response.CustomerResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ICustomerService {

    List<CustomerResponseDTO> findAll();
    CustomerResponseDTO findById(UUID id);
    CustomerResponseDTO create(CustomerRequestDTO request);

}
