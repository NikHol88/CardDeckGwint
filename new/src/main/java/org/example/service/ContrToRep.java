package org.example.service;

import org.example.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContrToRep {
    @Autowired
    CardRepository cardRepository;

    public CardRepository getCardRepository() {
        return cardRepository;
    }
}
