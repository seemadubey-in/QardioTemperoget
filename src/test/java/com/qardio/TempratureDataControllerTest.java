package com.qardio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.hamcrest.Matchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qardio.model.DailyTempData;
import com.qardio.model.HourlyTempData;
import com.qardio.model.TempAggregate;
import com.qardio.model.Temperature;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(TempratureDataController.class)
public class TempratureDataControllerTest {
	@MockBean
	TempratureDataController tempDataController;
	
	@Autowired
	private MockMvc mvc;
	
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void getAggregatedTempratureDatabyTerminalIdSuccess() throws Exception{
		TempAggregate tempAggregate = new TempAggregate();
		DailyTempData dailyTempData = new DailyTempData(new Date(), new java.math.BigDecimal("99.2"));
		List<DailyTempData> dailyDataList = new ArrayList<DailyTempData>();
		dailyDataList.add(dailyTempData);
		tempAggregate.setDailyTempList(dailyDataList);
		HourlyTempData hourlyData = new HourlyTempData(new Date(), 12, new BigDecimal("98.9"));
		List<HourlyTempData> hourlyDataList = new ArrayList<HourlyTempData>();
		hourlyDataList.add(hourlyData);
		tempAggregate.setHourlyTempList(hourlyDataList);
		tempAggregate.setTerminalId(111);
		given(tempDataController.getaggregatedData(tempAggregate.getTerminalId())).willReturn(tempAggregate);
		
		  mvc.perform(get("/getaggregated/111") .accept(MediaType.APPLICATION_JSON))
		  .andExpect(status().isOk())
		  .andExpect(jsonPath("terminalId", Matchers.equalTo(111)));
		 
		 
	}
	
	
	@Test
	public void addTemperatureData() throws Exception{
		Temperature temp = new Temperature();
		temp.setDateTemp("23-Jun-2021 11:20:21");
		temp.setTemp(new BigDecimal("98.3"));
		temp.setTerminalId(222);
		given(tempDataController.createTempData(temp)).willReturn(temp);
		 String json = mapper.writeValueAsString(temp);
		 mvc.perform(post("/createTempData").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
	                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	    
	}

}
