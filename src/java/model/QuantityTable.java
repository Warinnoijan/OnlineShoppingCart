/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author warin
 */
public class QuantityTable {
     public static List<Quantity> findAllQuantity() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        List<Quantity> qtList = null;
        try {
            qtList = (List<Quantity>) em.createNamedQuery("Quantity.findAll").getResultList();
            //em.close();

        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return qtList;
    }
public static Quantity findQuantityById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        Quantity quantity = null;
        try {
            quantity = em.find(Quantity.class, id);
            //em.close();

        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return quantity;
    }

    public static List<Quantity> findQuantityByIdCatalog(Quantity idDvdCatalog) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        List<Quantity> quantity = null;
        try {
            Query query = em.createNamedQuery("Quantity.findDvd_CatalogById");
            query.setParameter("idDvdCatalog", idDvdCatalog);
            quantity = (List<Quantity>) query.getResultList();
            if (quantity.isEmpty()) {
                return null;
            }
            //em.close();

        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return quantity;
    }

    //public static int updateEmployee(EntityManager em, 
    //        UserTransaction utx, Employee emp) {
    public static int updateQuantity(Quantity q) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Quantity target = em.find(Quantity.class, q.getId());
            if (target == null) {
                return 0;
            }
            target.setQuantity(q.getQuantity());
            em.persist(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);

        } finally {
            em.close();
            emf.close();
        }
        return 1;

    }

    public static int removeQuantity(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Quantity target = em.find(Quantity.class, id);
            if (target == null) {
                return 0;
            }
            em.remove(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);

        } finally {
            em.close();
            emf.close();
        }
        return 1;
    }

    public static int insertQuantity(Quantity q) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(q);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);

        } finally {
            em.close();
            emf.close();
        }
        return 1;
    }

    public static List<Quantity> findQuantityByIdCatalog(DvdCatalog catalog) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
