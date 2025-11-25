package com.gamesrental.api.model.entity;

import com.gamesrental.api.constant.TableCorporateConstant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = TableCorporateConstant.TABLE_RENTAL)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_rental")
    private UUID rentalId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_customer", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_game", nullable = false)
    private Game game;

    @Column(name = "rental_date")
    @CreatedDate
    private LocalDateTime rentalDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    private BigDecimal total;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

}