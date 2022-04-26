package com.app.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.CurrencyExchange;
import com.app.repo.ExchangeRepo;

@RestController
public class ControllerExchange {

	@Autowired
	Environment env;
	@Autowired
	ExchangeRepo repo;
	
	@GetMapping("/currency-exchange-h2/from/{from}/to/{to}")
	public ResponseEntity<CurrencyExchange> add(
			@PathVariable String from,
			@PathVariable String to
			){
		String port=env.getProperty("local.server.port");
		CurrencyExchange ce=new CurrencyExchange(1,from, to, BigDecimal.valueOf(60),port);
		return new ResponseEntity<CurrencyExchange>(ce,HttpStatus.OK);
	}
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ResponseEntity<CurrencyExchange> addH2(
			@PathVariable String from,
			@PathVariable String to
			){
		CurrencyExchange ce=repo.findByFromAndTo(from, to);
		return new ResponseEntity<CurrencyExchange>(ce,HttpStatus.OK);
	}
}
