package com.app.model;

import java.math.BigDecimal;

public class CurrencyConversion {

	private int id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmt;
	private String environment;
	public CurrencyConversion() {
		super();
	}
	public CurrencyConversion(int id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
			BigDecimal totalCalculatedAmt, String port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalCalculatedAmt = totalCalculatedAmt;
		this.environment = port;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalCalculatedAmt() {
		return totalCalculatedAmt;
	}
	public void setTotalCalculatedAmt(BigDecimal totalCalculatedAmt) {
		this.totalCalculatedAmt = totalCalculatedAmt;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String port) {
		this.environment = port;
	}
	@Override
	public String toString() {
		return "CurrencyConversion [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + ", quantity=" + quantity + ", totalCalculatedAmt=" + totalCalculatedAmt
				+ ", port=" + environment + "]";
	}
	
	
}
