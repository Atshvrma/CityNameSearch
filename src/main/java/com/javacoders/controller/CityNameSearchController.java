package com.javacoders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacoders.dto.CitySearchDto;
import com.javacoders.dto.Response;
import com.javacoders.helper.SearchHelper;
import com.javacoders.service.CitySearchService;

@RestController
public class CityNameSearchController {

	@Autowired
	SearchHelper helper;
	
	@Autowired
	CitySearchService searchService;
	
	@RequestMapping("/searchMatchingNames/{stringToMatch}/{range}")
	public Response searchCityName(@PathVariable String stringToMatch, @PathVariable int range) {
	
		
		CitySearchDto dto = helper.convertRequestParamToDto(stringToMatch,range);
		
		Response response = searchService.findSimilarNames(dto);
		
		return response;
	}
	
}
