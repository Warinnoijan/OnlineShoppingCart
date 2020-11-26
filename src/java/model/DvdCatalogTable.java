/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author warin
 */
public class DvdCatalogTable {

    public static List<DvdCatalog> findAllDvd_Catalog() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        List<DvdCatalog> dvdList = null;
        try {
            dvdList = (List<DvdCatalog>) em.createNamedQuery("DvdCatalog.findAll").getResultList();
            //em.close();

        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return dvdList;
    }

    public static DvdCatalog findDvd_CatalogById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        DvdCatalog catalog = null;
        try {
            catalog = em.find(DvdCatalog.class, id);
            //em.close();

        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return catalog;
    }

    //public static int updateEmployee(EntityManager em, 
    //        UserTransaction utx, Employee emp) {
    public static int updateDvd_Catalog(DvdCatalog catalog) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            DvdCatalog target = em.find(DvdCatalog.class, catalog.getId());
            if (target == null) {
                return 0;
            }
            target.setDvdNames(catalog.getDvdNames());
            target.setRate(catalog.getRate());
            target.setYear(catalog.getYear());
            target.setPrice(catalog.getPrice());
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

    public static int removeDvd_Catalog(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            DvdCatalog target = em.find(DvdCatalog.class, id);
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

    public static int insertDvd_Catalog(DvdCatalog catalog) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            DvdCatalog target = em.find(DvdCatalog.class, catalog.getId());
            if (target != null) {
                return 0;
            }
            em.persist(catalog);
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

}
