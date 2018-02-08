package com.liftoff.certificates.config;

import lombok.Data;

import java.util.Map;

/**
 * Created by vijay.hathimare on 1/26/18.
 *
 */
@Data
public class Database {
    private String url;
    private String driverClass;
    private String username;
    private String password;
    private Map<String, String> properties;
}