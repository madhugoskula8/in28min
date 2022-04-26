package com.app.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.CurrencyExchange;

@Repository
public interface ExchangeRepo extends JpaRepository<CurrencyExchange, Integer>{

	public CurrencyExchange findByFromAndTo(String from, String to);

}
