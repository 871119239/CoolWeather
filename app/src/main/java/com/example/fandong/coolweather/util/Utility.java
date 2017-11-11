package com.example.fandong.coolweather.util;

import android.text.TextUtils;

import com.example.fandong.coolweather.db.City;
import com.example.fandong.coolweather.db.Country;
import com.example.fandong.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * Created by fandong on 2017/11/11.
 */

public class Utility {
    /**/
    public  static boolean handleProvinceResponse(String response) throws JSONException {
        if (!TextUtils.isEmpty(response)) {
            JSONArray allProvinces=new JSONArray(response);
            for(int i=0;i<allProvinces.length();i++){
                JSONObject provinceObject=allProvinces.getJSONObject(i);
                Province  province=new Province();
                province.setProvinceName(provinceObject.getString("name"));
                province.setProvinceCode(provinceObject.getInt("id"));
                province.save();
            }
        }
        return false;
    }

    public static boolean handleCityResonse(String response,int provinceId) throws JSONException {
        if(!TextUtils.isEmpty(response)){
            JSONArray allCities=new JSONArray(response);
            for(int i=0;i<allCities.length();i++){
                JSONObject cityObject=allCities.optJSONObject(i);
                City city=new City();
                city.setCityName(cityObject.getString("name"));
                city.setCityCode(cityObject.getInt("id"));
                city.setProvinceId(provinceId);
                city.save();
            }
        }
        return  false;
    }

    public static boolean handleCountryResponse(String response,int cityId) throws JSONException {
        if(!TextUtils.isEmpty(response)){
            JSONArray allCountries=new JSONArray(response);
            for(int i=0;i<allCountries.length();i++){
                JSONObject countryObject=allCountries.getJSONObject(i);
                Country country=new Country();
                country.setCountryName(countryObject.getString("name"));
                country.setWeatherId(countryObject.getString("weather_id"));
                country.setCityId(cityId);
                country.save();
            }

        }
        return false;
    }
}
