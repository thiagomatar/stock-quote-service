package com.github.thiagomatar.quoteservice.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;

@Document
@Data
public class Quote {

    private String id;
    private String ticker;
    private BigDecimal price;
    private Instant instant;

}
