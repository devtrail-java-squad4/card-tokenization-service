package com.acabouomony.tokenization.service;

import com.acabouomony.tokenization.dto.CardTokenRequest;
import com.acabouomony.tokenization.dto.CardTokenResponse;
import com.acabouomony.tokenization.model.Card;

public interface CardTokenService {
    CardTokenResponse tokenizeCard(CardTokenRequest request);
    Card getCardByToken(String cardToken);
}