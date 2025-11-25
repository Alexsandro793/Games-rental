package com.gamesrental.api.model.entity;

import com.gamesrental.api.constant.TableCorporateConstant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = TableCorporateConstant.TABLE_CUSTOMER)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Customer {

    @Id
    @Column(name = "id_customer")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID customerId;

    private String name;
    private String email;
    private String phone;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

}
