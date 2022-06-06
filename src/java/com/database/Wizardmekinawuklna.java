/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database;

import java.io.Serializable;

import javax.faces.view.ViewScoped;

import javax.inject.Named;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author fedlu
 */

    @Named
@ViewScoped
public class Wizardmekinawuklna implements Serializable {
        private boolean skip;
   
  

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
         System.out.println("The Event Is called on Flowe "+event.getSource().toString());
        
        if (skip) {
            skip = false; //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
//    @PostConstruct
//    public void init()
//    {
//      
//    Wizardmekinawuklna w= new Wizardmekinawuklna();
//    }
}

