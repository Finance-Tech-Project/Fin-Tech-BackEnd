package com.fin_tech.dao;

import com.fin_tech.composite_key.StockQuoteId;
import com.fin_tech.model.StockQuote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StockQuoteRepository extends JpaRepository<StockQuote, StockQuoteId> {

    @Query("SELECT COUNT(sq) > 0 FROM StockQuote sq WHERE sq.id.symbol = :symbol")
    boolean existsBySymbol(@Param("symbol") String symbol);

    List<StockQuote> findByIdSymbolAndIdDateBetween(String ticker, LocalDate dateFrom, LocalDate dateTo);
}
