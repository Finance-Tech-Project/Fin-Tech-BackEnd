package com.fin_tech.composite_key;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StockQuoteId implements Serializable {
    private static final long serialVersionUID = 2822727999455974635L;
    @Column(nullable = false)
    LocalDate date;
    @Column(nullable = false)
    String symbol;
}
