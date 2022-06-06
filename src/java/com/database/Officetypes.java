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
@Table(name = "officetypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Officetypes.findAll", query = "SELECT o FROM Officetypes o"),
    @NamedQuery(name = "Officetypes.findById", query = "SELECT o FROM Officetypes o WHERE o.id = :id"),
    @NamedQuery(name = "Officetypes.findByName", query = "SELECT o FROM Officetypes o WHERE o.name = :name")})
public class Officetypes implements Serializable {

    @OneToMany(mappedBy = "organizationType")
    private Collection<Misikir> misikirCollection;

    @OneToMany(mappedBy = "organizationType")
    private Collection<Tewokay> tewokayCollection;

    @OneToMany(mappedBy = "organizationType")
    private Collection<Wekay> wekayCollection;

    @OneToMany(mappedBy = "yewokayAynet")
    private Collection<Wuklna> wuklnaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2000)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "organizationType")
    private Collection<Users> usersCollection;

    public Officetypes() {
    }

    public Officetypes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
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
        if (!(object instanceof Officetypes)) {
            return false;
        }
        Officetypes other = (Officetypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

    @XmlTransient
    public Collection<Wuklna> getWuklnaCollection() {
        return wuklnaCollection;
    }

    public void setWuklnaCollection(Collection<Wuklna> wuklnaCollection) {
        this.wuklnaCollection = wuklnaCollection;
    }

    @XmlTransient
    public Collection<Wekay> getWekayCollection() {
        return wekayCollection;
    }

    public void setWekayCollection(Collection<Wekay> wekayCollection) {
        this.wekayCollection = wekayCollection;
    }

    @XmlTransient
    public Collection<Tewokay> getTewokayCollection() {
        return tewokayCollection;
    }

    public void setTewokayCollection(Collection<Tewokay> tewokayCollection) {
        this.tewokayCollection = tewokayCollection;
    }

    @XmlTransient
    public Collection<Misikir> getMisikirCollection() {
        return misikirCollection;
    }

    public void setMisikirCollection(Collection<Misikir> misikirCollection) {
        this.misikirCollection = misikirCollection;
    }
    
}
