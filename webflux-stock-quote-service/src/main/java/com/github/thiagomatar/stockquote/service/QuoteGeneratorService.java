package com.github.thiagomatar.stockquote.service;

import com.github.thiagomatar.stockquote.model.Quote;
import reactor.core.publisher.Flux;

import java.time.Duration;

public interface QuoteGeneratorService {
    Flux<Quote> fetchQuoteStream(Duration period);
}
