package telran.fin_tech.parsing.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import telran.fin_tech.parsing.dto.StockQuoteDto;
import telran.fin_tech.parsing.dto.StockQuoteDtoOnce;
import telran.fin_tech.service.StockQuoteService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
//TODO добавить маппинг
public class ParsingController {
	final StockQuoteService stockQuoteService;
	
	@GetMapping("/history/{ticker}/{dateFrom}/{dateTo}/{interval}")
	public List<StockQuoteDtoOnce> getHistory(@PathVariable String ticker,@PathVariable String dateFrom, @PathVariable String dateTo,
			@PathVariable String interval ) throws URISyntaxException, IOException {
		return stockQuoteService.getHistoryByPeriod(ticker, dateFrom, dateTo, interval);
	}

	@GetMapping("/ticker/{ticker}")
	public List<StockQuoteDtoOnce> getRecentHistory(@PathVariable String ticker) throws URISyntaxException, IOException {
		String  dateTo = "2023-08-11";
		String dateFrom = "2023-08-15";
		return stockQuoteService.getHistoryByPeriod(ticker, dateFrom, dateTo, "1d");
	}
	
}
