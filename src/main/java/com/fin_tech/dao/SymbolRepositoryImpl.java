package com.fin_tech.dao;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fin_tech.dto.SymbolDto;
import com.fin_tech.model.Symbol;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Repository
    public class SymbolRepositoryImpl   {
//    SymbolRepository symbolRepository;
//    @PersistenceContext
//    EntityManager em;

//    @Override
//    public boolean existsById(String name) {
//        return em.find(Symbol.class, name) != null;
//    }

//    @Override
//    @Transactional
//    public Symbol save(Symbol symbol) {
//        em.persist(symbol);
//        return symbol;
//    }

//    @Override
//    @Transactional
//    public void deleteSymbol(Symbol symbol) {
//        em.remove(symbol);
//    }


//    @Override
//    @Transactional
//    public boolean addSymbol(SymbolDto symbolDto) {
//        if (existsById(symbolDto.getName())) {
//            return false;
//        }
//        Symbol symbol = new Symbol(symbolDto.getName(), symbolDto.getCompanyName(), symbolDto.getExchange(), symbolDto.getIndustryCategory(), symbolDto.getType());
//        save(symbol);
//        return true;
//    }


//    public Symbol getSymbol(String name) {
//        return symbolRepository.findByid(name);
//    }
//    @Transactional
//    @Override
//    public boolean loadSymbolsFromCSV(String csvFilePath) throws IOException, CsvValidationException {
//        Reader reader = new FileReader(csvFilePath);
//        CsvMapper mapper = new CsvMapper();
//        CsvSchema schema = mapper.schemaFor(Symbol.class).withColumnSeparator(';').withSkipFirstDataRow(true);
//        MappingIterator<Symbol> iterator = mapper.readerFor(Symbol.class).with(schema).readValues(reader);
//        List<Symbol> symbols = iterator.readAll();
//
//        for (Symbol symbol : symbols) {
//         em.persist(symbol);
//        }
//    return true;
//    }
}