package com.javacoders.service;

import com.javacoders.dto.CitySearchDto;
import com.javacoders.dto.Response;

public interface CitySearchService {

	public Response findSimilarNames(CitySearchDto dto);

}
