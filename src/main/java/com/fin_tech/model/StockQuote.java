package com.fin_tech.model;

import com.fin_tech.composite_key.StockQuoteId;
import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class StockQuote {
    @EmbeddedId
    StockQuoteId id;
    Double open;
    Double high;
    Double low;
    Double close;
    Long volume;

    public StockQuote(StockQuoteId id, Double open, Double high, Double low, Double close) {
    }


//    public LocalDate getDate() {
//        return getDate();
//    }

    public String getSymbol(){
        return getId().getSymbol();

    }
}
