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
@Table(name = "begoadragot")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Begoadragot.findAll", query = "SELECT b FROM Begoadragot b"),
    @NamedQuery(name = "Begoadragot.findById", query = "SELECT b FROM Begoadragot b WHERE b.id = :id"),
    @NamedQuery(name = "Begoadragot.findByYemahberusim", query = "SELECT b FROM Begoadragot b WHERE b.yemahberusim = :yemahberusim"),
    @NamedQuery(name = "Begoadragot.findByYemetubetken", query = "SELECT b FROM Begoadragot b WHERE b.yemetubetken = :yemetubetken"),
    @NamedQuery(name = "Begoadragot.findByAdrasha", query = "SELECT b FROM Begoadragot b WHERE b.adrasha = :adrasha"),
    @NamedQuery(name = "Begoadragot.findByYegenzebmeten", query = "SELECT b FROM Begoadragot b WHERE b.yegenzebmeten = :yegenzebmeten"),
    @NamedQuery(name = "Begoadragot.findByYeserawbalemuya", query = "SELECT b FROM Begoadragot b WHERE b.yeserawbalemuya = :yeserawbalemuya")})
public class Begoadragot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "yemahberusim")
    private String yemahberusim;
    @Size(max = 200)
    @Column(name = "yemetubetken")
    private String yemetubetken;
    @Size(max = 200)
    @Column(name = "adrasha")
    private String adrasha;
    @Size(max = 200)
    @Column(name = "yegenzebmeten")
    private String yegenzebmeten;
    @Size(max = 200)
    @Column(name = "yeserawbalemuya")
    private String yeserawbalemuya;

    public Begoadragot() {
    }

    public Begoadragot(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYemahberusim() {
        return yemahberusim;
    }

    public void setYemahberusim(String yemahberusim) {
        this.yemahberusim = yemahberusim;
    }

    public String getYemetubetken() {
        return yemetubetken;
    }

    public void setYemetubetken(String yemetubetken) {
        this.yemetubetken = yemetubetken;
    }

    public String getAdrasha() {
        return adrasha;
    }

    public void setAdrasha(String adrasha) {
        this.adrasha = adrasha;
    }

    public String getYegenzebmeten() {
        return yegenzebmeten;
    }

    public void setYegenzebmeten(String yegenzebmeten) {
        this.yegenzebmeten = yegenzebmeten;
    }

    public String getYeserawbalemuya() {
        return yeserawbalemuya;
    }

    public void setYeserawbalemuya(String yeserawbalemuya) {
        this.yeserawbalemuya = yeserawbalemuya;
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
        if (!(object instanceof Begoadragot)) {
            return false;
        }
        Begoadragot other = (Begoadragot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.databse.Begoadragot[ id=" + id + " ]";
    }
    
}
