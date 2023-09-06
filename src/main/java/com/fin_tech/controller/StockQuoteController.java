package com.fin_tech.controller;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.opencsv.exceptions.CsvValidationException;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fin_tech.service.StockQuoteService;
import com.fin_tech.dto.StockQuoteDto;
import com.fin_tech.dto.SymbolDto;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping
public class StockQuoteController {
    private final StockQuoteService stockQuoteService;

    @SneakyThrows
    @GetMapping("/start/{ticker}/history")
    public List<List<StockQuoteDto>> getQuotes(@PathVariable String ticker, @RequestParam String p) {
         return stockQuoteService.getQuotesByPeriodAndTicker( LocalDate.now().minusYears(2), LocalDate.now(),ticker);
    }
//
//    @PostMapping("/add")
//    public boolean parseCsv(@RequestBody SymbolDto symbolDto){
//        return stockQuoteService.addSymbol(symbolDto);
//    }

    @PostMapping("/symbols/add")
    public boolean parseCsv(@RequestParam String path) throws CsvValidationException, IOException {
        return stockQuoteService.loadSymbolsFromCSV(path);
    }

    @GetMapping("/quote/history")
    public List<List<StockQuoteDto>> getData (@RequestParam String dateFrom, @RequestParam String dateTo, @RequestParam String ticker ) throws Throwable {

//        LocalDateTime dateTimeFrom = LocalDateTime.ofInstant(Instant.ofEpochSecond(dateFrom), ZoneOffset.UTC);
//        LocalDateTime dateTimeTo = LocalDateTime.ofInstant(Instant.ofEpochSecond(dateTo), ZoneOffset.UTC);
        LocalDate end = LocalDate.parse(dateTo);
        LocalDate start = LocalDate.parse(dateFrom);
        return stockQuoteService.getData(start, end, ticker);
    }
}
