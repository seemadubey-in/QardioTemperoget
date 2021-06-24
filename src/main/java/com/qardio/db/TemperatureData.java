package com.qardio.db;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class TemperatureData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer readingId;
	private Integer terminalId;
	private BigDecimal temperature;
	private Timestamp dateCapture;
	
	public TemperatureData(Integer terminalId, BigDecimal temperature, Timestamp dateCapture) {
		this.terminalId = terminalId;
		this.temperature = temperature;
		this.dateCapture = dateCapture;
	}
	
	@Override
	public String toString() {
		return "readiId: " + readingId + " terminal: " + terminalId + " temp: " + temperature + "date: " + dateCapture;
	}
	
	public Integer getReadingId() {
		return readingId;
	}
	public void setReadingId(Integer readingId) {
		this.readingId = readingId;
	}
	public Integer getTerminalId() {
		return terminalId;
	}
	public void setTerminalId(Integer terminalId) {
		this.terminalId = terminalId;
	}
	public BigDecimal getTemperature() {
		return temperature;
	}
	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}
	public Timestamp getDateCapture() {
		return dateCapture;
	}
	public void setDateCapture(Timestamp dateCapture) {
		this.dateCapture = dateCapture;
	}
	
	
}
