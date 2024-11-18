package com.acabouomony.tokenization.controller;

import com.acabouomony.tokenization.dto.CardDetailsResponse;
import com.acabouomony.tokenization.dto.CardTokenRequest;
import com.acabouomony.tokenization.dto.CardTokenResponse;
import com.acabouomony.tokenization.model.Card;
import com.acabouomony.tokenization.service.CardTokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card-token")
@RequiredArgsConstructor
public class CardTokenController {

    private final CardTokenService cardTokenService;

    @PostMapping("/tokenize")
    public ResponseEntity<CardTokenResponse> tokenizeCard(@Valid @RequestBody CardTokenRequest request) {
        CardTokenResponse response = cardTokenService.tokenizeCard(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{token}")
    public ResponseEntity<CardDetailsResponse> getCardByToken(@PathVariable String token) {
        CardDetailsResponse cardDetails = cardTokenService.getCardByToken(token);
        return ResponseEntity.ok(cardDetails);
    }
}
