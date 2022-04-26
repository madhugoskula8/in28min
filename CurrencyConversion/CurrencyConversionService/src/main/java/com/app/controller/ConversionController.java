package com.app.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.model.CurrencyConversion;
import com.app.proxy.CurrencyExchangeProxy;


@RestController
public class ConversionController {
	@Autowired
	CurrencyExchangeProxy proxy;
//	@Autowired(required=true)
//	RestTemplate temp;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public ResponseEntity<CurrencyConversion> getAll(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			){
		java.util.Map<String, String> uriVar=new HashMap<>();
		uriVar.put("from", to);
		uriVar.put("to", to);
		CurrencyConversion c=new RestTemplate().getForEntity("http://localhost:9090/currency-exchange-h2/from/{from}/to/{to}",CurrencyConversion.class,uriVar).getBody();
	//	CurrencyConversion c=new ResponseEntity<CurrencyConversion>("http://localhost:9090/currency-exchange-h2/from/{from}/to/{to}",CurrencyConversion.class,uriVar).getBody();
		CurrencyConversion resp=new CurrencyConversion(1,from,to,c.getConversionMultiple(),quantity,quantity.multiply(c.getConversionMultiple()),c.getEnvironment());
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public ResponseEntity<CurrencyConversion> getAlls(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			){
		CurrencyConversion c=proxy.retriveExchange(from, to);
	//	CurrencyConversion c=new ResponseEntity<CurrencyConversion>("http://localhost:9090/currency-exchange-h2/from/{from}/to/{to}",CurrencyConversion.class,uriVar).getBody();
		CurrencyConversion resp=new CurrencyConversion(c.getId(),from,to,c.getConversionMultiple(),quantity,quantity.multiply(c.getConversionMultiple()),c.getEnvironment());
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}
}
