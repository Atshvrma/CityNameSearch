package com.javacoders.dto;

import java.util.Collections;
import java.util.List;

/** 
 * Object of this class will have the city list
 *  
 * @author atishv
 *
 */
public class CityListDto {

	
	private List<String> cityList;

	public List<String> getCityList() {
		Collections.sort(cityList);
		return cityList;
	}

	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}

	
	
	
}
