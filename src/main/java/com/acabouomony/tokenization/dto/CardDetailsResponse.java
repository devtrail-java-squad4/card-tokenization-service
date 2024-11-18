package com.acabouomony.tokenization.dto;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CardDetailsResponse {
    private String cardToken;
    private String maskedCardNumber;
    private String expirationDate;
    private String cardholderName;
}
