package com.app.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.model.CurrencyConversion;

//@FeignClient(name="currency-exchange",url="localhost:9090")
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retriveExchange(@PathVariable String from,
			@PathVariable String to);

}
