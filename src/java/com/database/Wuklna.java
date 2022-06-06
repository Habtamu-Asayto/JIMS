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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fedlu
 */
@Entity
@Table(name = "wuklna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wuklna.findAll", query = "SELECT w FROM Wuklna w"),
    @NamedQuery(name = "Wuklna.findById", query = "SELECT w FROM Wuklna w WHERE w.id = :id"),
    @NamedQuery(name = "Wuklna.findByYetewokayAynet", query = "SELECT w FROM Wuklna w WHERE w.yetewokayAynet = :yetewokayAynet")})
public class Wuklna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "yetewokay_aynet")
    private Integer yetewokayAynet;
    @JoinColumn(name = "yewokay_aynet", referencedColumnName = "id")
    @ManyToOne
    private Officetypes yewokayAynet;
    @JoinColumn(name = "misikir", referencedColumnName = "id")
    @ManyToOne
    private Users misikir;
    @JoinColumn(name = "tewokay", referencedColumnName = "id")
    @ManyToOne
    private Users tewokay;
    @JoinColumn(name = "wekay", referencedColumnName = "id")
    @ManyToOne
    private Users wekay;
    @JoinColumn(name = "yewuklnaaynet", referencedColumnName = "id")
    @ManyToOne
    private YewuklnaAynet yewuklnaaynet;

    public Wuklna() {
    }

    public Wuklna(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYetewokayAynet() {
        return yetewokayAynet;
    }

    public void setYetewokayAynet(Integer yetewokayAynet) {
        this.yetewokayAynet = yetewokayAynet;
    }

    public Officetypes getYewokayAynet() {
        return yewokayAynet;
    }

    public void setYewokayAynet(Officetypes yewokayAynet) {
        this.yewokayAynet = yewokayAynet;
    }

    public Users getMisikir() {
        return misikir;
    }

    public void setMisikir(Users misikir) {
        this.misikir = misikir;
    }

    public Users getTewokay() {
        return tewokay;
    }

    public void setTewokay(Users tewokay) {
        this.tewokay = tewokay;
    }

    public Users getWekay() {
        return wekay;
    }

    public void setWekay(Users wekay) {
        this.wekay = wekay;
    }

    public YewuklnaAynet getYewuklnaaynet() {
        return yewuklnaaynet;
    }

    public void setYewuklnaaynet(YewuklnaAynet yewuklnaaynet) {
        this.yewuklnaaynet = yewuklnaaynet;
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
        if (!(object instanceof Wuklna)) {
            return false;
        }
        Wuklna other = (Wuklna) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.database.Wuklna[ id=" + id + " ]";
    }
    
}
