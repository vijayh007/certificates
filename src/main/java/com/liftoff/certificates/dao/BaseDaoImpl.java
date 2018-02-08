package com.liftoff.certificates.dao;

import com.liftoff.certificates.entity.BaseDomain;
import com.liftoff.certificates.utils.JPAUtil;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by vijay.hathimare on 1/28/18.
 *
 */
@Slf4j
@Getter
@Setter
public class BaseDaoImpl<T extends BaseDomain> implements BaseDao<T> {
    private Class<T> clazz;

    public BaseDaoImpl(Class clazz) {
        this.clazz = clazz;
    }

    protected EntityManager getEntityManager() {
        return JPAUtil.getEntityManager();
    }

    @Override
    public T persist(T entity) {
        EntityManager entityManager = getEntityManager();
        try {
            if(entity.getCreatedAt() == null) {
                entity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            }
            if(entity.getUpdatedAt() == null) {
                entity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            }
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            entityManager.detach(entity);
            return entity;
        } catch (Exception e) {
            log.error("failed to persist entity of type {} data {} exception {}", clazz, entity, e);
            entityManager.getTransaction().rollback();
            return null;
        } finally {
            if(entityManager.isOpen()) entityManager.close();
        }
    }

    @Override
    public boolean delete(Object id) {
        EntityManager entityManager = getEntityManager();
        boolean deleted = false;
        try {
            entityManager.getTransaction().begin();
            T entity = entityManager.find(clazz, id);
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
            deleted = true;
        } catch (Exception e) {
            log.error("failed to delete entity of type {} data {} exception {}", clazz, id, e);
            entityManager.getTransaction().rollback();
            deleted = false;
        } finally {
            if(entityManager.isOpen()) entityManager.close();
        }
        return deleted;
    }

    @Override
    public T findById(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            T entity = entityManager.find(clazz, id);
            if(entity != null) entityManager.detach(entity);
            return entity;
        } catch (Exception e) {
            log.error("failed to find entity of type {} by id  {} exception {}", clazz, id, e);
            return null;
        } finally {
            if(entityManager.isOpen()) entityManager.close();
        }
    }

    @Override
    public T findById(String id) {
        EntityManager entityManager = getEntityManager();
        try {
            T entity = entityManager.find(clazz, id);
            if(entity != null) entityManager.detach(entity);
            return entity;
        } catch (Exception e) {
            log.error("failed to find entity of type {} by id  {} exception {}", clazz, id, e);
            return null;
        } finally {
            if(entityManager.isOpen()) entityManager.close();
        }
    }

    @Override
    public List<T> list(int pageNum, int pageSize) {
        EntityManager entityManager = getEntityManager();
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
            Root<T> from = criteriaQuery.from(clazz);
            CriteriaQuery<T> select = criteriaQuery.select(from);
            TypedQuery<T> typedQuery = entityManager.createQuery(select);
            typedQuery.setFirstResult((pageNum-1)*pageSize);
            typedQuery.setMaxResults(pageSize);
            List<T> resultList = typedQuery.getResultList();
            return resultList;
        } catch (Exception e) {
            log.error("failed to list entity of type {} for pageSize={} pageNum={} with " +
                    "exception {}", clazz, pageSize, pageNum, e);
            return null;
        } finally {
            if(entityManager.isOpen()) entityManager.close();
        }
    }

    @Override
    public T update(T entity) {
        EntityManager entityManager = getEntityManager();
        try{
            if(entity.getCreatedAt() == null) {
                entity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            }
            entity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            log.error("failed to update entity of type {} data {} exception {}", clazz, entity, e);
            entityManager.getTransaction().rollback();
            return null;
        } finally {
            if(entityManager.isOpen()) entityManager.close();
        }
    }

    @Override
    public <U> List<U> queryNamedQuery(String namedQuery, Class<U> resultObjectClass, Map<String, Object> parameters) {
        return queryNamedQuery(namedQuery, resultObjectClass, parameters, 0, 0);
    }

    @Override
    public <U> List<U> queryNamedQuery(String namedQuery, Class<U> resultObjectClass, Map<String, Object> parameters,
                                       int startRowPos, int size) {
        List<U> result = null;
        EntityManager entityManager = getEntityManager();
        try {
            Query query = entityManager.createNamedQuery(namedQuery, resultObjectClass);
            if(query != null) {
                if(parameters != null) {
                    for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                        query.setParameter(entry.getKey(), entry.getValue());
                    }
                }
                if(size > 0) {
                    query.setMaxResults(size);
                }
                if(startRowPos > 0) {
                    query.setFirstResult(startRowPos);
                }
                result = query.getResultList();
            }
            return result;
        } catch(Exception e) {
            log.error("failed to query {}, namedQuery {}, resultClass {}, params {} " +
                    "exception {}", clazz, namedQuery, resultObjectClass, parameters, e);
            return null;
        } finally {
            if(entityManager.isOpen()) entityManager.close();
        }
    }

}

