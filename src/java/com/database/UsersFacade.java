/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fedlu
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "WeredaFitihPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }

    public Users findLogeduserfitih(String email, String pwdd) {
       
         Users logged=null;
            String lowerusername=email.toLowerCase();
            try{
       logged= (Users) em.createQuery("SELECT u FROM Users u WHERE lower(u.email) = :email and u.password = :password"  ).setParameter("email",lowerusername).setParameter("password",pwdd).getSingleResult();
        
            }
            catch(Exception e){
            logged=null;
              
            }
        
       return logged;
    }
    
}
