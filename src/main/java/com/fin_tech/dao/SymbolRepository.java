package com.fin_tech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fin_tech.model.Symbol;



public interface SymbolRepository extends JpaRepository<Symbol, String> {
	
public Symbol findByTicker(String name);
}
