package com.liftoff.certificates.utils;

import com.liftoff.certificates.config.Database;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vijay.hathimare on 1/28/18.
 */
@Slf4j
public final class JPAUtil {
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManager  getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void createEntityManagerFactory(Database dbConfig) {
        Map<String, String> jpaProps = new HashMap();
//        Configuring JDBC properties
        jpaProps.put("javax.persistence.jdbc.url", dbConfig.getUrl());
        jpaProps.put("javax.persistence.jdbc.user", dbConfig.getUsername());
        jpaProps.put("javax.persistence.jdbc.password", dbConfig.getPassword());
        jpaProps.put("javax.persistence.jdbc.driver", dbConfig.getDriverClass());

        Map<String, String> properties = dbConfig.getProperties();
        for (Map.Entry<String, String> entry : properties.entrySet()) {
                jpaProps.put(entry.getKey(), entry.getValue());
        }
        log.info("JPA props -> {}", jpaProps);

        entityManagerFactory = Persistence.createEntityManagerFactory("certificates", jpaProps);
    }
}

