package com.qardio.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;




public class Temperature {
	private Integer terminalId;
	@NotNull(message = "Please provide Temprature value")
	private BigDecimal temp;
	@NotNull(message = "Please provide date value in format dd-MMM-yyyy HH:mm:ss ")
	private String dateTemp; //"11-Jun-2021 17:23:54"; dd-MMM-yyyy HH:mm:ss
	
	public Temperature() {
		super();
	}
	public Temperature(int terminalId, BigDecimal temp, String dateTemp) {
		this.terminalId = terminalId;
		this.temp = temp;
		this.dateTemp = dateTemp;
	}
	public int getTerminalId() {
		return terminalId;
	}
	public void setTerminalId(int terminalId) {
		this.terminalId = terminalId;
	}
	
	
	public String getDateTemp() {
		return dateTemp;
	}
	public void setDateTemp(String dateTemp) {
		this.dateTemp = dateTemp;
	}
	public BigDecimal getTemp() {
		return temp;
	}
	public void setTemp(BigDecimal temp) {
		this.temp = temp;
	}
	@Override
	public String toString() {
		return "terminalId: " + this.terminalId + " temp: " + this.temp + " dateTemp: " + this.dateTemp;
	}
	
	
}
