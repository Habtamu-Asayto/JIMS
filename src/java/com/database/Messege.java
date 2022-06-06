/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fedlu
 */
@Entity
@Table(name = "messege")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Messege.findAll", query = "SELECT m FROM Messege m"),
    @NamedQuery(name = "Messege.findById", query = "SELECT m FROM Messege m WHERE m.id = :id"),
    @NamedQuery(name = "Messege.findByDayOne", query = "SELECT m FROM Messege m WHERE m.dayOne = :dayOne"),
    @NamedQuery(name = "Messege.findByDayTwo", query = "SELECT m FROM Messege m WHERE m.dayTwo = :dayTwo"),
    @NamedQuery(name = "Messege.findByDayThreeMsg", query = "SELECT m FROM Messege m WHERE m.dayThreeMsg = :dayThreeMsg"),
    @NamedQuery(name = "Messege.findByRegistrationMessage", query = "SELECT m FROM Messege m WHERE m.registrationMessage = :registrationMessage")})
public class Messege implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "day_one")
    private String dayOne;
    @Size(max = 200)
    @Column(name = "day_two")
    private String dayTwo;
    @Size(max = 200)
    @Column(name = "day_three_msg")
    private String dayThreeMsg;
    @Size(max = 200)
    @Column(name = "registration_message")
    private String registrationMessage;

    public Messege() {
    }

    public Messege(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDayOne() {
        return dayOne;
    }

    public void setDayOne(String dayOne) {
        this.dayOne = dayOne;
    }

    public String getDayTwo() {
        return dayTwo;
    }

    public void setDayTwo(String dayTwo) {
        this.dayTwo = dayTwo;
    }

    public String getDayThreeMsg() {
        return dayThreeMsg;
    }

    public void setDayThreeMsg(String dayThreeMsg) {
        this.dayThreeMsg = dayThreeMsg;
    }

    public String getRegistrationMessage() {
        return registrationMessage;
    }

    public void setRegistrationMessage(String registrationMessage) {
        this.registrationMessage = registrationMessage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Messege)) {
            return false;
        }
        Messege other = (Messege) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return dayOne;
    }
    
}
