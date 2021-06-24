package com.qardio.model;

import java.math.BigDecimal;
import java.util.Date;

public class DailyTempData {
	
	private Date dailydateCaptured;
	
	private BigDecimal dailyTemprature;

	public DailyTempData(Date dailydateCaptured, BigDecimal dailyTemprature) {
		super();
		this.dailydateCaptured = dailydateCaptured;
		this.dailyTemprature = dailyTemprature;
	}

	public Date getDailydateCaptured() {
		return dailydateCaptured;
	}

	public void setDailydateCaptured(Date dailydateCaptured) {
		this.dailydateCaptured = dailydateCaptured;
	}

	public BigDecimal getDailyTemprature() {
		return dailyTemprature;
	}

	public void setDailyTemprature(BigDecimal dailyTemprature) {
		this.dailyTemprature = dailyTemprature;
	}

	
	
	

}
