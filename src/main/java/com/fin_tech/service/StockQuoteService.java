package com.fin_tech.service;

import com.fin_tech.composite_key.StockQuoteId;
import com.fin_tech.dao.StockQuoteRepository;
import com.fin_tech.dto.StockQuoteDto;
import com.fin_tech.model.StockQuote;
import com.fin_tech.util.HistoryDateGetter;
import com.fin_tech.util.StockQuoteProcessor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StockQuoteService  {
    private StockQuoteRepository stockQuoteRepository;
    ModelMapper mapper = new ModelMapper();
    StockQuoteProcessor processor = new StockQuoteProcessor();
    HistoryDateGetter getter = new HistoryDateGetter();

    public List<StockQuote> getQuotesByPeriodAndTicker(LocalDate dateFrom, LocalDate dateTo, String ticker) {
        LocalDate start = LocalDate.of(dateFrom.getYear(), Month.JANUARY, 1);
        LocalDate end = LocalDate.of(dateTo.getYear(), Month.DECEMBER, 31);
        return stockQuoteRepository.findByIdSymbolAndIdDateBetween(ticker, start, end);
    }

    private boolean checkIfDataExistsInDatabase(String symbol) {
        return stockQuoteRepository.existsBySymbol(symbol);
    }

    public List<List<StockQuoteDto>> processClientRequest(LocalDate dateFrom, LocalDate dateTo, String symbol) {
        LocalDate start = LocalDate.of(dateFrom.getYear(), Month.JANUARY, 1);
        LocalDate end = LocalDate.of(dateTo.getYear(), Month.DECEMBER, 31);
        if (checkIfDataExistsInDatabase(symbol)) {
                List<StockQuote> quotes =  getQuotesByPeriodAndTicker(start, end, symbol);
                List<StockQuoteDto> quoteDtos = quotes.stream().map(quote -> mapper.map(quote,StockQuoteDto.class)).collect(Collectors.toList());
                return processor.getAllQuoteLists(quoteDtos);
            } else {
                List<StockQuoteDto>quoteDtos  = getter.getAllHistoryStockQuotes(symbol);
                List<StockQuote> stockQuote = quoteDtos.stream()
                        .map(quote -> new StockQuote(new StockQuoteId(quote.getDate(), symbol), quote.getOpen(),quote.getHigh(), quote.getLow(),quote.getClose(),quote.getVolume()))
                        .collect(Collectors.toList());
                stockQuoteRepository.saveAll(stockQuote);
                List <StockQuoteDto>quotesByYahoo = quoteDtos.stream()
                        .filter(quote -> quote.getDate().isAfter(dateFrom.minusDays(1)) && quote.getDate().isBefore(dateTo.plusDays(1)))
                        .map(quote -> mapper.map(quote,StockQuoteDto.class))
                        .collect(Collectors.toList());
                return processor.getAllQuoteLists(quotesByYahoo);
        }
    }
}