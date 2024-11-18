package com.acabouomony.tokenization.service.impl;

import com.acabouomony.tokenization.dto.CardDetailsResponse;
import com.acabouomony.tokenization.dto.CardTokenRequest;
import com.acabouomony.tokenization.dto.CardTokenResponse;
import com.acabouomony.tokenization.model.Card;
import com.acabouomony.tokenization.repository.CardRepository;
import com.acabouomony.tokenization.service.CardTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import com.acabouomony.tokenization.util.EncryptionUtil;

@Service
@RequiredArgsConstructor
public class CardTokenServiceImpl implements CardTokenService {

    private final CardRepository cardRepository;

    @Override
    public CardTokenResponse tokenizeCard(CardTokenRequest request) {
        String cardToken = UUID.randomUUID().toString(); // Generate unique token
        String maskedCardNumber = maskCardNumber(request.getCardNumber());
        String encryptedCardNumber = EncryptionUtil.encrypt(request.getCardNumber());

        Card card = new Card();
        card.setCardToken(cardToken);
        card.setMaskedCardNumber(maskedCardNumber);
        card.setExpirationDate(request.getExpirationDate());
        card.setCardholderName(request.getCardholderName());
        // Save encrypted card number
        card.setEncryptedCardNumber(encryptedCardNumber);

        cardRepository.save(card);

        return new CardTokenResponse(cardToken);
    }

    @Override
    public CardDetailsResponse getCardByToken(String cardToken) {
        Card card = cardRepository.findByCardToken(cardToken);
        if (card != null) {
            return new CardDetailsResponse(
                    card.getCardToken(),
                    card.getMaskedCardNumber(),
                    card.getExpirationDate(),
                    card.getCardholderName()
            );
        }
        throw new RuntimeException("Card not found");
    }

    private String maskCardNumber(String cardNumber) {
        // Mask the card number for security, e.g., 1234-XXXX-XXXX-5678
        return "XXXX-XXXX-XXXX-" + cardNumber.substring(cardNumber.length() - 4);
    }
}