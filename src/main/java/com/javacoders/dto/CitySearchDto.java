package com.javacoders.dto;

import java.util.List;

/**
 * Dto for city search
 * @author atishv
 *
 */
public class CitySearchDto {

	private String cityName;
	private int maxLimit;
	private List<String> cityList ;
	
	
	
	 
	public List<String> getCityList() {
		return cityList;
	}
	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}
	public int getMaxLimit() {
		return maxLimit;
	}
	public void setMaxLimit(int maxLimit) {
		this.maxLimit = maxLimit;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
	
}
