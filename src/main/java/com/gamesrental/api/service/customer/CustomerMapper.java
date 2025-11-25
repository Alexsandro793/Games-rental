package com.gamesrental.api.service.customer;

import com.gamesrental.api.model.dto.request.CustomerRequestDTO;
import com.gamesrental.api.model.dto.response.CustomerResponseDTO;
import com.gamesrental.api.model.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerMapper {

    private final ModelMapper mapper;

    public CustomerResponseDTO mapEntityToDTO(Customer source) {
        return mapper.map(source, CustomerResponseDTO.class);
    }

    public Customer mapDTOToEntity(CustomerRequestDTO source) {
        return mapper.map(source, Customer.class);
    }

    public List<CustomerResponseDTO> mapEntityToDTO(List<Customer> source) {
        return source.stream().map(this::mapEntityToDTO).toList();
    }

}
