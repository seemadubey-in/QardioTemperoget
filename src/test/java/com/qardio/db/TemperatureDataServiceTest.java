package com.qardio.db;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.qardio.model.DailyTempData;
import com.qardio.model.HourlyTempData;
import com.qardio.model.TempAggregate;
import com.qardio.model.Temperature;

@RunWith(SpringRunner.class)
@WebMvcTest(TemperatureDataService.class)
public class TemperatureDataServiceTest {
	@MockBean
	TemperatureDataService tempdataservice;
	
	@Test
	public void saveTempDataTest() {
		Temperature temp = new Temperature();
		temp.setDateTemp("23-Jun-2021 11:20:21");
		temp.setTemp(new BigDecimal("98.3"));
		temp.setTerminalId(222);
		doNothing().when(tempdataservice).saveTempDataFromQue(temp);
		tempdataservice.saveTempDataFromQue(temp);
		verify(tempdataservice, times(1)).saveTempDataFromQue(temp);
	}
	
	@Test
	public void getHourlytempDataTest() {
		HourlyTempData hourlyTempData = new HourlyTempData(new Date(), 0, new BigDecimal("98.4"));
		List<HourlyTempData> hourlydatList =  new ArrayList<HourlyTempData>();
		hourlydatList.add(hourlyTempData);
		given(tempdataservice.getHourlyTemprature(111)).willReturn(hourlydatList);
		assertThat(hourlydatList.size()).isGreaterThan(0);
	}
	
	@Test
	public void getDailytempDataTest() {
		DailyTempData dailyTempData = new DailyTempData(new Date(), new BigDecimal("98.4"));
		List<DailyTempData> dailydatList =  new ArrayList<DailyTempData>();
		dailydatList.add(dailyTempData);
		given(tempdataservice.getDailyTemprature(111)).willReturn(dailydatList);
		assertThat(dailydatList.size()).isGreaterThan(0);
	}

	@Test
	public void getaggregatedtempDataTest() {
		HourlyTempData hourlyTempData = new HourlyTempData(new Date(), 0, new BigDecimal("98.4"));
		List<HourlyTempData> hourlydatList =  new ArrayList<HourlyTempData>();
		hourlydatList.add(hourlyTempData);
		DailyTempData dailyTempData = new DailyTempData(new Date(), new BigDecimal("98.4"));
		List<DailyTempData> dailydatList =  new ArrayList<DailyTempData>();
		dailydatList.add(dailyTempData);
		TempAggregate aggregateData = new TempAggregate();
		aggregateData.setTerminalId(111);
		aggregateData.setHourlyTempList(hourlydatList);
		aggregateData.setDailyTempList(dailydatList);
		given(tempdataservice.getAggregratedTempData(111)).willReturn(aggregateData);
		assertThat(aggregateData.getTerminalId()).isEqualTo(111);
	}
	
	

}
