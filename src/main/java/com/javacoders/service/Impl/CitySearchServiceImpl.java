package com.javacoders.service.Impl
;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacoders.dto.CitySearchDto;
import com.javacoders.dto.Response;
import com.javacoders.helper.CityListLoader;
import com.javacoders.helper.SearchHelper;
import com.javacoders.service.CitySearchService;

/**
 * This class will help us to read the content from csv file and then shortlist the requested names
 * 
 * @author atishv
 *
 */
@Service(value="searchService")
public class CitySearchServiceImpl implements CitySearchService{
	
	@Autowired
	SearchHelper helper;
	
	@Autowired 
	CityListLoader listLoader;
	
	@Override
	public Response findSimilarNames(CitySearchDto dto) {
		
		Response response = new Response();
		// check if request is valid 
		if(helper.isRequestValid(dto)) {
		
			// get the list of the city from the csv file which has been intialized at the time of application start up
			List<String> cityList = listLoader.cityListDto.getCityList();
			
			dto.setCityList(cityList);
			
			List<String> shortlistedCityNames  = helper.shortListCityNamesAsPerRequest(dto);
			if(shortlistedCityNames!=null && !shortlistedCityNames.isEmpty()) {
				response.setData(shortlistedCityNames);
			}else {
				List<String> list = new ArrayList<String>();
				list.add("No Matches found, try again with other parameters");
				response.setData(list);
			}
			response.setStatus("Success");
		}else {
			
			List<String> list =  new ArrayList<String>();
			list.add("Bad Parameters");
			response.setStatus("Failed");
			response.setData(list);
		}
				
		return response;
	}

}
