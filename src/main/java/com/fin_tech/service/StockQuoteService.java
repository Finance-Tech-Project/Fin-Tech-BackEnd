package com.fin_tech.service;

import com.fin_tech.dao.StockQuoteRepository;
import com.fin_tech.dao.StockQuoteRepositoryImpl;
import com.fin_tech.dao.SymbolRepository;
import com.fin_tech.dao.SymbolRepositoryImpl;
import com.fin_tech.dto.StockQuoteDto;
import com.fin_tech.dto.SymbolDto;
import com.fin_tech.model.Symbol;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface StockQuoteService  {


    List<List<StockQuoteDto>> getQuotesByPeriodAndTicker(LocalDate dateFrom, LocalDate dateTo, String ticker) ;

//	boolean checkIfDataExistsInDatabase(String ticker) ;

    List<List<StockQuoteDto>> getData(LocalDate dateFrom, LocalDate dateTo, String ticker) throws Throwable;

    Double getSimpleProfitStockByPeriod(String s, String s1, String s2);


    boolean addSymbol(SymbolDto symbolDto) ;
    boolean loadSymbolsFromCSV(String csvFilePath) throws CsvValidationException, IOException;

//    private Symbol getSymbol (String ticker);

//    boolean existsById(Symbol symbol);
}


