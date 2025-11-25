package com.gamesrental.api.service.customer;

import com.gamesrental.api.exception.BadRequestException;
import com.gamesrental.api.exception.NotFoundException;
import com.gamesrental.api.interfaces.ICustomerService;
import com.gamesrental.api.model.dto.request.CustomerRequestDTO;
import com.gamesrental.api.model.dto.response.CustomerResponseDTO;
import com.gamesrental.api.model.entity.Customer;
import com.gamesrental.api.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Override
    public List<CustomerResponseDTO> findAll() {
        return mapper.mapEntityToDTO(repository.findAll());
    }

    @Override
    public CustomerResponseDTO findById(UUID id) {
        return mapper.mapEntityToDTO(repository.findById(id).orElseThrow(() -> new NotFoundException("Cliente não encontrado.")));
    }

    @Override
    public CustomerResponseDTO create(CustomerRequestDTO request) {
        Optional<Customer> dbCustomer = repository.findByEmail(request.getEmail());

        if (dbCustomer.isPresent()) {
            throw new BadRequestException("Cliente já cadastrado");
        }

        Customer newCustomer = mapper.mapDTOToEntity(request);

        repository.save(newCustomer);

        return mapper.mapEntityToDTO(newCustomer);
    }

}
