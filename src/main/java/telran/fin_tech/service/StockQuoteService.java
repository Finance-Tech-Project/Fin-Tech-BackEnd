package telran.fin_tech.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import telran.fin_tech.parsing.HTMLParser;
import telran.fin_tech.parsing.dto.StockQuoteDto;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockQuoteService {
	private final StockQuoteRepository stockQuoteRepository;
	public final HTMLParser parser;
	
	public StockQuoteDto getHistoryByPeriod(String ticker, String dateFrom, String dateTo,
			String interval) throws URISyntaxException, IOException {
		return parser.parseTable(ticker, dateFrom, dateTo, interval);
	}
}

