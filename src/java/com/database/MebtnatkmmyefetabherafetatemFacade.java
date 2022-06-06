/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fedlu
 */
@Stateless
public class MebtnatkmmyefetabherafetatemFacade extends AbstractFacade<Mebtnatkmmyefetabherafetatem> {

    @PersistenceContext(unitName = "WeredaFitihPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MebtnatkmmyefetabherafetatemFacade() {
        super(Mebtnatkmmyefetabherafetatem.class);
    }

   public List<Mebtnatkmmyefetabherafetatem> getTodayketero(String today) {
      List<Mebtnatkmmyefetabherafetatem> todaylist=null;
           
      todaylist=em.createQuery("SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.ketero = :ketero").setParameter("ketero", today).getResultList();
              
        System.out.println("Today ketero list is  => " + todaylist.size());
                
          return todaylist;
    }
    
}
