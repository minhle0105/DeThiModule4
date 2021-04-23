package com.minhle.dethimodule4.repository;

import com.minhle.dethimodule4.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends JpaRepository<City, Long> {

    @Query("select c from City c where c.name=:cityName")
    City findCityByName(@Param("cityName") String cityName);

}
