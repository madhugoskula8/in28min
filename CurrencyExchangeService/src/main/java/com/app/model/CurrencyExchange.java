package com.app.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="currencyexchange")
public class CurrencyExchange {

	@Id
	@GeneratedValue
	private int id;
	@Column(name="exchangefrom")
	private String from;
	@Column(name="conversionto")
	private String  to;
	@Column(name="conversionmultiple")
	private BigDecimal conversionMultiple;
	@Column(name="port")
	private String environment;
	//insert into currencyexchange(id,exchangefrom,exchangefrom,conversionmultiple,port) values(1001,"USD","INR",60,"9090");
	//insert into CURRENCYEXCHANGE(id,exchangefrom,exchangefrom,conversionmultiple,port) values(1001,"USD","INR",60,"9090");
	//INSERT INTO CURRENCYEXCHANGE(ID,EXCHANGEFROM,CONVERSIONTO,CONVERSIONMULTIPLE,PORT) VALUES(1,"USD","INR",60,"9090");
	public CurrencyExchange() {
		super();
	}
	public CurrencyExchange(int id, String from, String to, BigDecimal conversionMultiple, String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.environment = environment;
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
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	@Override
	public String toString() {
		return "CurrencyExchange [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + ", environment=" + environment + "]";
	}
	
	
}
