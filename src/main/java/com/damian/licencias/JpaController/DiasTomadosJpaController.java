/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damian.licencias.JpaController;

import com.damian.licencias.JpaController.exceptions.NonexistentEntityException;
import com.damian.licencias.model.DiasTomados;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author piotr
 */
public class DiasTomadosJpaController implements Serializable {

    public DiasTomadosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DiasTomados diasTomados) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(diasTomados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DiasTomados diasTomados) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            diasTomados = em.merge(diasTomados);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = diasTomados.getId();
                if (findDiasTomados(id) == null) {
                    throw new NonexistentEntityException("The diasTomados with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DiasTomados diasTomados;
            try {
                diasTomados = em.getReference(DiasTomados.class, id);
                diasTomados.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The diasTomados with id " + id + " no longer exists.", enfe);
            }
            em.remove(diasTomados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DiasTomados> findDiasTomadosEntities() {
        return findDiasTomadosEntities(true, -1, -1);
    }

    public List<DiasTomados> findDiasTomadosEntities(int maxResults, int firstResult) {
        return findDiasTomadosEntities(false, maxResults, firstResult);
    }

    private List<DiasTomados> findDiasTomadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DiasTomados.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public DiasTomados findDiasTomados(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DiasTomados.class, id);
        } finally {
            em.close();
        }
    }

    public int getDiasTomadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DiasTomados> rt = cq.from(DiasTomados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
