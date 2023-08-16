package telran.fin_tech.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import telran.fin_tech.parsing.dto.StockQuoteDto;
import telran.fin_tech.parsing.dto.StockQuoteDtoOnce;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockQuoteService {
	private final StockQuoteRepository stockQuoteRepository;
	public final HTMLParser parser;
	
	public List<StockQuoteDtoOnce> getHistoryByPeriod(String ticker, String dateFrom, String dateTo,
													  String interval) throws URISyntaxException, IOException {
		parser.setTicker(ticker);
		parser.setDateFrom(LocalDate.parse(dateFrom));
		parser.setDateTo(LocalDate.parse(dateTo));
		parser.setInterval(interval);
		parser.setFrequency("1d");
		parser.setFilter("history");
		parser.setIncludeAdjustedClose("true");
		return parser.parseTable();
	}
}

