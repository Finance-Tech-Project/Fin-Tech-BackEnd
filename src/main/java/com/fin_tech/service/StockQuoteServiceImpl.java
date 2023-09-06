package com.fin_tech.service;

import com.fin_tech.dao.StockQuoteRepository;
import com.fin_tech.dao.SymbolRepository;
import com.fin_tech.dto.StockQuoteDto;
import com.fin_tech.dto.SymbolDto;
import com.fin_tech.model.StockQuote;
import com.fin_tech.composite_key.StockQuoteId;
import com.fin_tech.model.Symbol;
import com.fin_tech.util.HistoryDateGetter;
import com.fin_tech.util.StockQuoteProcessor;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Repository
@RequiredArgsConstructor
public class StockQuoteServiceImpl implements StockQuoteService {
	final StockQuoteRepository stockQuoteRepository;
	final SymbolRepository symbolRepository;
	ModelMapper mapper = new ModelMapper();
	StockQuoteProcessor processor = new StockQuoteProcessor();
	HistoryDateGetter getter = new HistoryDateGetter();
	@PersistenceContext
	EntityManager em;

	@Override

	public List<List<StockQuoteDto>> getQuotesByPeriodAndTicker( LocalDate dateFrom, LocalDate dateTo, String ticker) {
		Symbol symbol = getSymbol(ticker);

		List<StockQuote> quotes = stockQuoteRepository.findAllById_Symbol(symbol);
		LocalDate start = dateFrom.withMonth(1).withDayOfMonth(1);
		LocalDate end = dateTo.withMonth(12).withDayOfMonth(31);
			List list =	quotes.stream()
				.filter(quote -> quote.getId().getDate().isAfter(start.minusDays(1)) && quote.getId().getDate().isBefore(end.plusDays(1)))
				.map(quote -> new StockQuoteDto(quote.getId().getDate(), quote.getOpen(), quote.getHigh(), quote.getLow(),quote.getClose(),quote.getVolume()))
				.collect(Collectors.toList());
		return processor.getAllQuoteLists(list, dateFrom, dateTo);
	}

		@Override
	@Transactional
	public boolean addSymbol(SymbolDto symbolDto) {
		if (existsById(symbolDto.getName())) {
			return false;
		}
		Symbol symbol = new Symbol(symbolDto.getName(), symbolDto.getCompanyName(), symbolDto.getExchange(), symbolDto.getIndustryCategory(), symbolDto.getType());
		symbolRepository.save(symbol);
		return true;
	}

	@Override
	@Transactional
	public List<List<StockQuoteDto>> getData(LocalDate dateFrom, LocalDate dateTo,  String ticker ){

		if (existsById(ticker)) {
			return getQuotesByPeriodAndTicker(dateFrom, dateTo, ticker);
		} else {

			List<StockQuoteDto> quotes =  getter.getAllHistoryStockQuotes(ticker);
			List<StockQuote> stockQuotes= new ArrayList<>();

			for(StockQuoteDto quote : quotes){
				StockQuoteId id = new StockQuoteId(quote.getDate(), (Symbol) getSymbol(ticker));
				StockQuote stockQuote = new StockQuote(id, quote.getOpen(),
						quote.getHigh(), quote.getLow(), quote.getClose(), quote.getVolume());
				stockQuoteRepository.save(stockQuote);
				stockQuotes.add(stockQuote);
			}

List result = new ArrayList<>();
			for (StockQuoteDto quote : quotes){
				if (quote.getDate().isBefore(dateTo)  &&  quote.getDate().isAfter(dateFrom))
					result.add(quote);

			}
			return processor.getAllQuoteLists(result, dateFrom, dateTo);
		}
	}

	@Override
	public Double getSimpleProfitStockByPeriod(String s, String s1, String s2) {
		return null;
	}


	@Override
	public boolean loadSymbolsFromCSV(String csvFilePath) throws CsvValidationException, IOException {
		return loadSymbolsFromCSV(csvFilePath);
}

	private void saveAll(List<StockQuote> stockQuote) {
		for (int i = 0; i < stockQuote.size(); i++) {
			System.out.println(stockQuoteRepository.save(stockQuote.get(i)));

			}
		}



	private Symbol getSymbol(String ticker){

		return Optional.of(symbolRepository.findById(ticker).orElseThrow(null)).get();
	}

	private boolean existsById(String name) {
		Symbol symbol =  getSymbol(name);
		List res = stockQuoteRepository.findAllById_Symbol(symbol);
		return  res.size() != 0;
	}
}
