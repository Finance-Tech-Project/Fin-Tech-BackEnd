package com.fin_tech.model;

import com.fin_tech.composite_key.StockQuoteId;
import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@Table(name = "stock_quotes")
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
