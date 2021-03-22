package com.github.thiagomatar.quoteservice.repositories;

import com.github.thiagomatar.quoteservice.domain.Quote;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends ReactiveMongoRepository<Quote, String> {
}
