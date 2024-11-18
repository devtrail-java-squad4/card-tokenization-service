package com.acabouomony.tokenization.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cards")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cardToken;

    @Column(nullable = false)
    private String maskedCardNumber;

    @Column(nullable = false)
    private String encryptedCardNumber;

    @Column(nullable = false)
    private String expirationDate;

    @Column(nullable = false)
    private String cardholderName;
}
