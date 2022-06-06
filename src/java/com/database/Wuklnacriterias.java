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
 * @author habtamu
 */
@Entity
@Table(name = "wuklnacriterias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wuklnacriterias.findAll", query = "SELECT w FROM Wuklnacriterias w"),
    @NamedQuery(name = "Wuklnacriterias.findById", query = "SELECT w FROM Wuklnacriterias w WHERE w.id = :id"),
    @NamedQuery(name = "Wuklnacriterias.findByType", query = "SELECT w FROM Wuklnacriterias w WHERE w.type = :type"),
    @NamedQuery(name = "Wuklnacriterias.findByInformation", query = "SELECT w FROM Wuklnacriterias w WHERE w.information = :information")})
public class Wuklnacriterias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2000)
    @Column(name = "type")
    private String type;
    @Size(max = 2147483647)
    @Column(name = "information")
    private String information;

    public Wuklnacriterias() {
    }

    public Wuklnacriterias(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
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
        if (!(object instanceof Wuklnacriterias)) {
            return false;
        }
        Wuklnacriterias other = (Wuklnacriterias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.database.Wuklnacriterias[ id=" + id + " ]";
    }
    
}
