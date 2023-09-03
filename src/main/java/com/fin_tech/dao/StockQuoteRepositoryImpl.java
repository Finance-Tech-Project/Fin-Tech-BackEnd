package com.fin_tech.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class StockQuoteRepositoryImpl {
//    final StockQuoteRepository stockQuoteRepository;
//    final SymbolRepository symbolRepository;
    @PersistenceContext
      EntityManager em;

//@Override
//    public boolean existsBySymbol(Symbol symbol) {
//    Query query = em.createQuery("SELECT sq FROM StockQuote  sq WHERE sq.id.symbol = :symbol" );
//            query.setParameter("symbol", symbol) ;
//
//boolean result = query.getSingleResult() != null;
//       return result;
//    }




//    public List<StockQuote> findAllByIdIdAndDateBetween(Symbol symbol, LocalDate startDate, LocalDate endDate) {
//        Query query = em.createQuery("SELECT sq FROM StockQuote sq WHERE sq.id.symbol.name = :symbol AND sq.id.date BETWEEN :startDate AND :endDate");
//        query.setParameter("symbol", symbol);
//        query.setParameter("startDate", startDate);
//        query.setParameter("endDate", endDate);
//       List<StockQuote> list = query.getResultList();
//        return list;
//    }

//    @Transactional

//    public   StockQuote  save(StockQuote quote) {
//        return null;
//    }
//
//
//    public Optional<StockQuote> findById(StockQuoteId stockQuoteId) {
//        return Optional.empty();
//    }


//    public boolean existsById(StockQuoteId stockQuoteId) {
//        return false;
//    }

//    @Transactional
//    public void saveAll(List<StockQuote> stockQuote) {
//        for (int i = 0; i < stockQuote.size(); i++) {
//            em.persist(stockQuote.get(i));
//            if ((i != 0 &&i % 50 == 0 )|| i == stockQuote.size() - 1) {
//                em.flush();
//                em.clear();
//            }
//        }
//    }
}
