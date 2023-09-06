package com.fin_tech.model;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fin_tech.composite_key.StockQuoteId;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Table(name = "stockquote")
public class StockQuote {
    @EmbeddedId
    StockQuoteId id;
    Double open;
    Double high;
    Double low;
    Double close;
    Long volume;

//    public LocalDate getDate() {
//        return getDate();
//    }
//
//    public Symbol getSymbol(){
//        return getSymbol();
//
//    }
}
