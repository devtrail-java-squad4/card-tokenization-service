package com.acabouomony.tokenization.repository;

import com.acabouomony.tokenization.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Card findByCardToken(String cardToken);
}

