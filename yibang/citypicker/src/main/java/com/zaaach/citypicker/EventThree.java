package com.zaaach.citypicker;

import com.zaaach.citypicker.model.City;

import java.util.List;

/**
 * Created by M 4700 on 2017/6/25.
 */

public class EventThree {
    List<City> allCitys;

    public EventThree(List<City> allCitys) {
        this.allCitys = allCitys;
    }

    public List<City> getAllCitys() {
        return allCitys;
    }
}
