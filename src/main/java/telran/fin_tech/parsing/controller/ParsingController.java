package telran.fin_tech.parsing.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import telran.fin_tech.parsing.dto.StockQuoteDto;
import telran.fin_tech.service.StockQuoteService;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
//TODO добавить маппинг
public class ParsingController {
	final StockQuoteService stockQuoteService;
	
	@GetMapping("{ticker}/history?{dateFrom}&{dateTo}&{interval}")
	public StockQuoteDto getHistory(@PathVariable String ticker,@PathVariable String dateFrom, @PathVariable String dateTo,
			@PathVariable String interval ) throws URISyntaxException, IOException {
		return stockQuoteService.getHistoryByPeriod(ticker, dateFrom, dateTo, interval);
	}
	
}
