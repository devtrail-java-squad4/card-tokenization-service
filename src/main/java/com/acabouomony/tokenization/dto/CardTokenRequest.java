package com.acabouomony.tokenization.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardTokenRequest {
    @NotBlank(message = "Card number is mandatory")
    private String cardNumber;

    @NotBlank(message = "Expiration date is mandatory")
    private String expirationDate;

    @NotBlank(message = "Cardholder name is mandatory")
    private String cardholderName;

    @NotBlank(message = "CVV is mandatory")
    private String cvv;
}
