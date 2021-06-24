package com.qardio.db;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qardio.exception.RecordNotFoundException;
import com.qardio.model.DailyTempData;
import com.qardio.model.HourlyTempData;
import com.qardio.model.TempAggregate;
import com.qardio.model.Temperature;

@Service
public class TemperatureDataService {

	@Autowired
	TemperatureDataRepo tempRepo;
	
	
	public void saveTempDataFromQue(Temperature temp) {
		
		//String sdate = "11-Jun-2021 17:23:54";
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");  
		Date date = new Date();
		try {
			date = formatter.parse(temp.getDateTemp());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("dte is: " + date);
		Timestamp timecaptured = new Timestamp( date.getTime());
		
		TemperatureData tempData = new TemperatureData(temp.getTerminalId(), temp.getTemp(), timecaptured);
		System.out.println("writing into db: " + tempData);
		tempRepo.save(tempData);
		
	}
	
	public List<HourlyTempData> getHourlyTemprature(Integer terminalId){
		final Calendar date = Calendar.getInstance();
	    date.add(Calendar.DATE, -1);
	    Date previousDate=date.getTime();
	    Date now=new Date();
		List<HourlyTempData> hourlyTempDataList = tempRepo.getHourlyTempratureData(previousDate,now,terminalId);
		return hourlyTempDataList;
	}
	
	public List<DailyTempData> getDailyTemprature(Integer terminalId){
		 final Calendar date = Calendar.getInstance();
		    date.add(Calendar.DATE, -7);
		    Date previousDate=date.getTime();
		    Date now=new Date();
		List<DailyTempData> dailyTempDataList = tempRepo.getDailyTempratureData(previousDate,now,terminalId);
		System.out.println("ertertertert"+dailyTempDataList.size());
		return dailyTempDataList;
	}
	
	public TempAggregate getAggregratedTempData(Integer terminalId){
		List<HourlyTempData> hourlyData = getHourlyTemprature(terminalId);
		List<DailyTempData> dailyData = getDailyTemprature(terminalId);
		if(hourlyData.size()==0 && dailyData.size()==0) {
			throw new RecordNotFoundException("terminal id not found");
		}
		TempAggregate aggreatedData = new TempAggregate();
		aggreatedData.setHourlyTempList(hourlyData);
		aggreatedData.setDailyTempList(dailyData);
		aggreatedData.setTerminalId(terminalId);
		return aggreatedData;
	
	}
	
}
