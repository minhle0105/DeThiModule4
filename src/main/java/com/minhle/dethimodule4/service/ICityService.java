package com.minhle.dethimodule4.service;

import com.minhle.dethimodule4.model.City;

public interface ICityService extends IGeneralService<City> {
    City findCityByName(String cityName);
}
