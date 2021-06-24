package com.qardio.db;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qardio.model.DailyTempData;
import com.qardio.model.HourlyTempData;

@Repository
public interface TemperatureDataRepo extends JpaRepository<TemperatureData, Integer> {
	
	@Query("SELECT new com.qardio.model.HourlyTempData(date(t.dateCapture),hour(t.dateCapture),max(t.temperature)) "
			  + "FROM TemperatureData t where terminalId = ?3 and date(t.dateCapture) between  ?1 AND ?2 "
			  + "GROUP BY hour(t.dateCapture) ")
			List<HourlyTempData> getHourlyTempratureData(Date previous, Date now, Integer terminalId);
	
	@Query("SELECT new com.qardio.model.DailyTempData(date(t.dateCapture),max(t.temperature)) "
			  + "FROM TemperatureData t where terminalId = ?3 and date(t.dateCapture) between  ?1 AND ?2 "
			  + "GROUP BY date(t.dateCapture) ")
			List<DailyTempData> getDailyTempratureData(Date previous, Date now, Integer terminalId);

}
