package com.fin_tech.dao;

import com.fin_tech.composite_key.StockQuoteId;
import com.fin_tech.model.StockQuote;
import com.fin_tech.model.Symbol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StockQuoteRepository extends JpaRepository<StockQuote, StockQuoteId> {

    @Query("SELECT COUNT(sq) > 0 FROM StockQuote sq WHERE sq.id.symbol = :symbol")
    boolean existsBySymbol(@Param("symbol") Symbol symbol);

    List<StockQuote> findByIdSymbolAndIdDateBetween(Symbol symbol, LocalDate dateFrom, LocalDate dateTo);
}
