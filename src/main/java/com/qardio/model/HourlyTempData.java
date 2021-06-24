package com.qardio.model;

import java.math.BigDecimal;
import java.util.Date;

public class HourlyTempData {
	
	private Date dateCaptured;
	
	private int hourCaptured;
	
	private BigDecimal hourlyTemprature;

	public HourlyTempData(Date dateCaptured, int hourCaptured, BigDecimal hourlyTemprature) {
		super();
		this.dateCaptured = dateCaptured;
		this.hourCaptured = hourCaptured;
		this.hourlyTemprature = hourlyTemprature;
	}

	public Date getDateCaptured() {
		return dateCaptured;
	}

	public void setDateCaptured(Date dateCaptured) {
		this.dateCaptured = dateCaptured;
	}

	public int getHourCaptured() {
		return hourCaptured;
	}

	public void setHourCaptured(int hourCaptured) {
		this.hourCaptured = hourCaptured;
	}

	public BigDecimal getHourlyTemprature() {
		return hourlyTemprature;
	}

	public void setHourlyTemprature(BigDecimal hourlyTemprature) {
		this.hourlyTemprature = hourlyTemprature;
	}
	
	

}
