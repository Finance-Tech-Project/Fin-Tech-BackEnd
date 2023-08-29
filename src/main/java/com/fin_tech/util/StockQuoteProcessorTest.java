package com.fin_tech.util;

import com.fin_tech.dto.StockQuoteDto;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class StockQuoteProcessorTest {
    static HTMLParser parser = new HTMLParser();
   static final StockQuoteProcessor processor = new StockQuoteProcessor(LocalDate.of(2023,8,4), LocalDate.of(2023, 8, 27));

    public static void main(String[] args) throws IOException, InterruptedException {
        List<StockQuoteDto> table = parser.getDaylyHistoryByPeriod();
        Thread.sleep(10000);
        System.out.println(processor.getDailyStockQuotes(table));
//        System.out.println(processor.getMonthlyStockQuotes(parser.getDaylyHistoryByPeriod()));
    }
}
