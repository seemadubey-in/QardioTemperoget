package com.qardio.model;

import java.util.List;

public class TempAggregate {
	
	private int terminalId;
	
	private List<HourlyTempData> hourlyTempList;
	
	private List<DailyTempData> dailyTempList;

	public int getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(int terminalId) {
		this.terminalId = terminalId;
	}

	public List<HourlyTempData> getHourlyTempList() {
		return hourlyTempList;
	}

	public void setHourlyTempList(List<HourlyTempData> hourlyTempList) {
		this.hourlyTempList = hourlyTempList;
	}

	public List<DailyTempData> getDailyTempList() {
		return dailyTempList;
	}

	public void setDailyTempList(List<DailyTempData> dailyTempList) {
		this.dailyTempList = dailyTempList;
	}
	
	

}
