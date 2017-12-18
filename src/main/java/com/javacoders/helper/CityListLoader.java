package com.javacoders.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.javacoders.dto.CityListDto;

@Component
public class CityListLoader {

	public  CityListDto cityListDto = null;
	
	@PostConstruct
	public void loadCityList() {
		cityListDto = new CityListDto();
		List<String> cityList = new ArrayList<String>();
		try {
			InputStream in =  getClass().getClassLoader().getResourceAsStream("CityNameList.csv");
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String currentLine = null;
			
			while((currentLine = reader.readLine() )!=null) {
				cityList.add(currentLine);
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		cityListDto.setCityList(cityList);
	}
	
	
}
