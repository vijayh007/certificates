package com.liftoff.certificates.log;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vijay.hathimare on 1/29/18.
 */
@Converter
@Slf4j
public class MapToStringConverter implements AttributeConverter<Map<String, String>, String> {

   // @Override
    public String convertToDatabaseColumn(Map<String, String> stringStringMap) {
        if(stringStringMap == null)
            return null;
        return stringStringMap.toString();
    }

   // @Override
    public Map<String, String> convertToEntityAttribute(String s) {
        if(s == null)
            return null;
        Map<String, String> newMap = new HashMap();
        newMap.put("extra", "extravalue");
        return newMap;
    }
}

