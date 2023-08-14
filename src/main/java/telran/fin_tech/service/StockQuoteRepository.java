package telran.fin_tech.service;

import org.springframework.data.jpa.repository.JpaRepository;
import telran.fin_tech.model.StockQuote;

import java.time.LocalDate;

public interface StockQuoteRepository extends JpaRepository<StockQuote, LocalDate> {

	
}
