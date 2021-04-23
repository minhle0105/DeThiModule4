package com.minhle.dethimodule4.service;

import com.minhle.dethimodule4.model.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICityService extends IGeneralService<City> {
    City findCityByName(String cityName);
}
