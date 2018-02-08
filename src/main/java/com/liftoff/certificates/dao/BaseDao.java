package com.liftoff.certificates.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by vijay.hathimare on 1/28/18.
 */
public interface BaseDao<T> {
    T persist(T entity);
    boolean delete(Object id);
    T findById(Long id);
    List<T> list(int pageNum, int pageSize);
    T update(T entity);
    T findById(String id);
    <U> List<U> queryNamedQuery(String namedQuery, Class<U> resultObjectClass, Map<String, Object> parameters);
    <U> List<U> queryNamedQuery(String namedQuery, Class<U> resultObjectClass, Map<String, Object> parameters,
                                int startRowPos, int size);
}
