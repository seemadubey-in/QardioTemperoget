package com.qardio;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qardio.db.TemperatureDataService;
import com.qardio.model.TempAggregate;
import com.qardio.model.Temperature;

@RestController
public class TempratureDataController {
	@Autowired
	private TemperatureDataService tempDataService;
	
	
	
	@PostMapping("/createTempData")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Temperature createTempData(@Valid @RequestBody Temperature temp) {
		System.out.println("inside post: " + temp);
		tempDataService.saveTempDataFromQue(temp);
		return temp;
		
	}
	@GetMapping("/getaggregated/{terminalId}")
	@ResponseStatus(value = HttpStatus.OK)
	public TempAggregate getaggregatedData(@PathVariable ("terminalId") Integer terminalId) {
		TempAggregate tempAggregate = tempDataService.getAggregratedTempData(terminalId);
		return tempAggregate;
	}

}
