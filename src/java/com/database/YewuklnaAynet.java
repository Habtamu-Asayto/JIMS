/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fedlu
 */
@Entity
@Table(name = "yewuklna_aynet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "YewuklnaAynet.findAll", query = "SELECT y FROM YewuklnaAynet y"),
    @NamedQuery(name = "YewuklnaAynet.findById", query = "SELECT y FROM YewuklnaAynet y WHERE y.id = :id"),
    @NamedQuery(name = "YewuklnaAynet.findByYewuklnaSim", query = "SELECT y FROM YewuklnaAynet y WHERE y.yewuklnaSim = :yewuklnaSim")})
public class YewuklnaAynet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2000)
    @Column(name = "yewuklna_sim")
    private String yewuklnaSim;
    @OneToMany(mappedBy = "yewuklnaaynet")
    private Collection<Wuklna> wuklnaCollection;

    public YewuklnaAynet() {
    }

    public YewuklnaAynet(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYewuklnaSim() {
        return yewuklnaSim;
    }

    public void setYewuklnaSim(String yewuklnaSim) {
        this.yewuklnaSim = yewuklnaSim;
    }

    @XmlTransient
    public Collection<Wuklna> getWuklnaCollection() {
        return wuklnaCollection;
    }

    public void setWuklnaCollection(Collection<Wuklna> wuklnaCollection) {
        this.wuklnaCollection = wuklnaCollection;
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
        if (!(object instanceof YewuklnaAynet)) {
            return false;
        }
        YewuklnaAynet other = (YewuklnaAynet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.database.YewuklnaAynet[ id=" + id + " ]";
    }
    
}
