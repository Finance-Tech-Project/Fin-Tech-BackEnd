package com.fin_tech.dao;

import com.fin_tech.model.StockQuote;
import com.fin_tech.model.Symbol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StockQuoteRepository  extends JpaRepository<StockQuote,Symbol>{


@Query("select sq from StockQuote sq where sq.id.symbol = :symbol and sq.id.date between :startdate and :enddate")
public List<StockQuote> findAllByIdAndDateBetween(@Param("startdate") LocalDate dateFrom,
                                                        @Param("enddate") LocalDate dateTo,
                                                        @Param("symbol") Symbol symbol);


//    StockQuote  save(StockQuote quote);
//
    List <StockQuote> findAllById_Symbol(Symbol symbol);
//
//    boolean existsById(StockQuoteId stockQuoteId);

//    void saveAll(List<StockQuote> stockQuote);
}
