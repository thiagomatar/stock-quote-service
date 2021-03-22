package com.github.thiagomatar.quoteservice.service;

import com.github.thiagomatar.quoteservice.client.StockQuoteClient;
import com.github.thiagomatar.quoteservice.domain.Quote;
import com.github.thiagomatar.quoteservice.repositories.QuoteRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Created by jt on 10/19/17.
 */
@Service
public class QuoteMonitorService implements ApplicationListener<ContextRefreshedEvent> {

    private final StockQuoteClient stockQuoteClient;
    private final QuoteRepository quoteRepository;

    public QuoteMonitorService(StockQuoteClient stockQuoteClient, QuoteRepository quoteRepository) {
        this.stockQuoteClient = stockQuoteClient;
        this.quoteRepository = quoteRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        stockQuoteClient.getQuoteStream()
                .log("quote-monitor-service")
                .subscribe(quote -> {
                    Mono<Quote> savedQuote = quoteRepository.save(quote);
                    System.out.println("I saved a quote! Id: " +savedQuote.share().block().getId());
                });
    }
}