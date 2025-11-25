package com.gamesrental.api.service.rental;

import com.gamesrental.api.exception.NotFoundException;
import com.gamesrental.api.exception.UnprocessableEntityException;
import com.gamesrental.api.interfaces.IRentalService;
import com.gamesrental.api.model.dto.request.RentalRequestDTO;
import com.gamesrental.api.model.dto.response.RentalResponseDTO;
import com.gamesrental.api.model.entity.Customer;
import com.gamesrental.api.model.entity.Game;
import com.gamesrental.api.model.entity.Rental;
import com.gamesrental.api.repository.CustomerRepository;
import com.gamesrental.api.repository.GameRepository;
import com.gamesrental.api.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements IRentalService {

    private final RentalRepository repository;
    private final RentalMapper mapper;
    private final GameRepository gameRepository;
    private final CustomerRepository customerRepository;

    @Override
    public List<RentalResponseDTO> findAll() {
        return mapper.mapEntityToDTO(repository.findAll());
    }

    @Override
    public RentalResponseDTO findById(UUID id) {
        return mapper.mapEntityToDTO(repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Aluguel não encontrado.")));
    }

    public Rental findEntityById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Aluguel não encontrado."));
    }


    @Override
    public RentalResponseDTO create(RentalRequestDTO request) {
        Game game = gameRepository.findById(request.getGameId())
                .orElseThrow(() -> new NotFoundException("Jogo não encontrado."));

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado."));

        if (game.getQuantity().equals(0)) {
            throw new UnprocessableEntityException("Este jogo não está disponível para aluguel");
        }

        Rental newRental = Rental.builder()
                .customer(customer)
                .game(game).build();

        game.setQuantity(game.getQuantity() - 1);

        repository.save(newRental);
        gameRepository.save(game);

        return mapper.mapEntityToDTO(newRental);
    }

    @Override
    public RentalResponseDTO rentalReturn(UUID id) {
        Rental rental = findEntityById(id);

        if (rental.getReturnDate() != null) {
            throw new UnprocessableEntityException("Aluguel já devolvido.");
        }

        Game game = gameRepository.findById(rental.getGame().getGameId())
                .orElseThrow(() -> new NotFoundException("Jogo não encontrado."));

        rental.setReturnDate(LocalDateTime.now());

        long days = Duration.between(rental.getRentalDate(), rental.getReturnDate()).toDays();

        if (days == 0) {
            days = 1;
        }

        BigDecimal total = game.getDailyFee().multiply(BigDecimal.valueOf(days));

        rental.setTotal(total);
        game.setQuantity(game.getQuantity() + 1);

        repository.save(rental);
        gameRepository.save(game);

        return mapper.mapEntityToDTO(rental);
    }

}
