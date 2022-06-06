/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author habtamu
 */
@Entity
@Table(name = "datetime")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datetime.findAll", query = "SELECT d FROM Datetime d"),
    @NamedQuery(name = "Datetime.findById", query = "SELECT d FROM Datetime d WHERE d.id = :id"),
    @NamedQuery(name = "Datetime.findByDateandtime", query = "SELECT d FROM Datetime d WHERE d.dateandtime = :dateandtime"),
    @NamedQuery(name = "Datetime.findByCurrentdate", query = "SELECT d FROM Datetime d WHERE d.currentdate = :currentdate")})
public class Datetime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dateandtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateandtime;
    @Column(name = "currentdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date currentdate;

    public Datetime() {
    }

    public Datetime(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Date getDateandtime() { 
       return dateandtime;
    }

    public void setDateandtime(Date dateandtime) {
        this.dateandtime = dateandtime;
    }

    public Date getCurrentdate() {
        return currentdate;
    }

    public void setCurrentdate(Date currentdate) {
        this.currentdate = currentdate;
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
        if (!(object instanceof Datetime)) {
            return false;
        }
        Datetime other = (Datetime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.database.Datetime[ id=" + id + " ]";
    }    
}
