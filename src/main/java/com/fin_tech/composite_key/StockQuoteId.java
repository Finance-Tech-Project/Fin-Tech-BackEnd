package com.fin_tech.composite_key;

import com.fin_tech.model.Symbol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StockQuoteId implements Serializable {

    @Column(nullable = false)
    LocalDate date;
    @ManyToOne
    Symbol symbol;
}
