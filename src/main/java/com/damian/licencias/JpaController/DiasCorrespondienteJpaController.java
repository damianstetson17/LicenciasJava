/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damian.licencias.JpaController;

import com.damian.licencias.JpaController.exceptions.NonexistentEntityException;
import com.damian.licencias.model.DiasCorrespondiente;
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
public class DiasCorrespondienteJpaController implements Serializable {

    public DiasCorrespondienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DiasCorrespondiente diasCorrespondiente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(diasCorrespondiente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DiasCorrespondiente diasCorrespondiente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            diasCorrespondiente = em.merge(diasCorrespondiente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = diasCorrespondiente.getId();
                if (findDiasCorrespondiente(id) == null) {
                    throw new NonexistentEntityException("The diasCorrespondiente with id " + id + " no longer exists.");
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
            DiasCorrespondiente diasCorrespondiente;
            try {
                diasCorrespondiente = em.getReference(DiasCorrespondiente.class, id);
                diasCorrespondiente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The diasCorrespondiente with id " + id + " no longer exists.", enfe);
            }
            em.remove(diasCorrespondiente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DiasCorrespondiente> findDiasCorrespondienteEntities() {
        return findDiasCorrespondienteEntities(true, -1, -1);
    }

    public List<DiasCorrespondiente> findDiasCorrespondienteEntities(int maxResults, int firstResult) {
        return findDiasCorrespondienteEntities(false, maxResults, firstResult);
    }

    private List<DiasCorrespondiente> findDiasCorrespondienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DiasCorrespondiente.class));
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

    public DiasCorrespondiente findDiasCorrespondiente(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DiasCorrespondiente.class, id);
        } finally {
            em.close();
        }
    }

    public int getDiasCorrespondienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DiasCorrespondiente> rt = cq.from(DiasCorrespondiente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
