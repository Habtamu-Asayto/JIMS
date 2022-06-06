/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import reports.MonthsandDataFeedcovid;

/**
 *
 * @author fedlu
 */
@Stateless
public class MonthsandDataFeedcovidFacade extends AbstractFacade<MonthsandDataFeedcovid> {

    @PersistenceContext(unitName = "WeredaFitihPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MonthsandDataFeedcovidFacade() {
        super(MonthsandDataFeedcovid.class);
    }
    
}
