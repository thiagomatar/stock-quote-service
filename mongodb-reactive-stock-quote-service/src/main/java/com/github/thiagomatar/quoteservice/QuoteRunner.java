package com.github.thiagomatar.quoteservice;

import com.github.thiagomatar.quoteservice.client.StockQuoteClient;
import com.github.thiagomatar.quoteservice.domain.Quote;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class QuoteRunner implements CommandLineRunner {

    private final StockQuoteClient client;

    @Override
    public void run(String... args) throws Exception {
        Flux<Quote> quoteStream = client.getQuoteStream();
        quoteStream.subscribe(System.out::println);
    }
}
