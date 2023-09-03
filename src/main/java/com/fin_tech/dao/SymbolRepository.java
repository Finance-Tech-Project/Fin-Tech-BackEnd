package com.fin_tech.dao;

import com.fin_tech.dto.SymbolDto;
import com.opencsv.exceptions.CsvValidationException;
import com.fin_tech.model.Symbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.IOException;

@EnableJpaRepositories
@Repository
public interface SymbolRepository  extends JpaRepository <Symbol, String>{

//    boolean existsById(String name);
//
//    @Transactional
//    Symbol save(Symbol symbol);
//
//    void deleteSymbol(Symbol symbol);
//
//    boolean addSymbol(SymbolDto symbolDto);

//    @Query("SELECT s FROM  Symbol s WHERE s.name = :ticker")
//    Symbol getSymbol(String ticker);

//    @Transactional
//    boolean loadSymbolsFromCSV(String csvFilePath) throws IOException, CsvValidationException;

//    Symbol findByid(String name);
}
