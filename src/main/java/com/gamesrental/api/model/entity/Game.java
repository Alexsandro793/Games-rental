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
@Table(name = TableCorporateConstant.TABLE_GAME)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_game")
    private UUID gameId;

    private String title;
    private String platform;
    private String genre;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "daily_fee")
    private BigDecimal dailyFee;

    private Integer quantity;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

}