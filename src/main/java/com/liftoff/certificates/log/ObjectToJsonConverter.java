package com.liftoff.certificates.log;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Map;

/**
 * Created by vijay.hathimare on 1/29/18.
 */
@Slf4j
@Converter
public class ObjectToJsonConverter implements AttributeConverter<Object, String> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

   // @Override
    public String convertToDatabaseColumn(Object o) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch(Exception e) {
            return null;
        }
    }

   // @Override
    public Object convertToEntityAttribute(String s) {
        try {
            return objectMapper.readValue(s, Map.class);
        } catch (Exception e) {
            return null;
        }
    }
}
