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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "zones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zones.findAll", query = "SELECT z FROM Zones z"),
    @NamedQuery(name = "Zones.findById", query = "SELECT z FROM Zones z WHERE z.id = :id"),
    @NamedQuery(name = "Zones.findByZonename", query = "SELECT z FROM Zones z WHERE z.zonename = :zonename")})
public class Zones implements Serializable {

    @OneToMany(mappedBy = "zone")
    private Collection<Misikir> misikirCollection;

    @OneToMany(mappedBy = "zone")
    private Collection<Tewokay> tewokayCollection;

    @OneToMany(mappedBy = "zone")
    private Collection<Wekay> wekayCollection;

    @OneToMany(mappedBy = "zone")
    private Collection<Users> usersCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "zonename")
    private String zonename;
    @OneToMany(mappedBy = "zoneid")
    private Collection<Weredas> weredasCollection;
    @OneToMany(mappedBy = "kesashzoneid")
    private Collection<Yigbagnayigbagnmels> yigbagnayigbagnmelsCollection;
    @OneToMany(mappedBy = "tekesashzoneid")
    private Collection<Yigbagnayigbagnmels> yigbagnayigbagnmelsCollection1;
    @OneToMany(mappedBy = "zone")
    private Collection<Yigbagnayigbagnmels> yigbagnayigbagnmelsCollection2;
    @OneToMany(mappedBy = "zone")
    private Collection<Meritizazandabetuta> meritizazandabetutaCollection;
    @OneToMany(mappedBy = "zoneid")
    private Collection<Meritizazandabetuta> meritizazandabetutaCollection1;
    @OneToMany(mappedBy = "kesashzoneid")
    private Collection<Wenjelmezgebkedamimrmra> wenjelmezgebkedamimrmraCollection;
    @OneToMany(mappedBy = "tekesashzoneid")
    private Collection<Wenjelmezgebkedamimrmra> wenjelmezgebkedamimrmraCollection1;
    @OneToMany(mappedBy = "wenjeluzone")
    private Collection<Wenjelmezgebkedamimrmra> wenjelmezgebkedamimrmraCollection2;
    @JoinColumn(name = "regionid", referencedColumnName = "id")
    @ManyToOne
    private Regions regionid;
    @OneToMany(mappedBy = "kesashzoneid")
    private Collection<Mebtnatkmmyefetabherafetatem> mebtnatkmmyefetabherafetatemCollection;
    @OneToMany(mappedBy = "tekesashzoneid")
    private Collection<Mebtnatkmmyefetabherafetatem> mebtnatkmmyefetabherafetatemCollection1;
    @OneToMany(mappedBy = "zoneid")
    private Collection<Mebtnatkmmyefetabherafetatem> mebtnatkmmyefetabherafetatemCollection2;
    @OneToMany(mappedBy = "kesashzoneid")
    private Collection<Wengelabetuta> wengelabetutaCollection;
    @OneToMany(mappedBy = "tekesashzoneid")
    private Collection<Wengelabetuta> wengelabetutaCollection1;
    @OneToMany(mappedBy = "kesashzoneid")
    private Collection<Qettegnakisandkesemelsmezgeb> qettegnakisandkesemelsmezgebCollection;
    @OneToMany(mappedBy = "tekesashzoneid")
    private Collection<Qettegnakisandkesemelsmezgeb> qettegnakisandkesemelsmezgebCollection1;
    @OneToMany(mappedBy = "zoneid")
    private Collection<Qettegnakisandkesemelsmezgeb> qettegnakisandkesemelsmezgebCollection2;
    @OneToMany(mappedBy = "zoneid")
    private Collection<Senedochenatebekoch> senedochenatebekochCollection;
    @OneToMany(mappedBy = "kesashzoneid")
    private Collection<Wengelwastna> wengelwastnaCollection;
    @OneToMany(mappedBy = "tekesashzoneid")
    private Collection<Wengelwastna> wengelwastnaCollection1;
    @OneToMany(mappedBy = "zoneid")
    private Collection<Wengelwastna> wengelwastnaCollection2;

    public Zones() {
    }

    public Zones(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZonename() {
        return zonename;
    }

    public void setZonename(String zonename) {
        this.zonename = zonename;
    }

    @XmlTransient
    public Collection<Weredas> getWeredasCollection() {
        return weredasCollection;
    }

    public void setWeredasCollection(Collection<Weredas> weredasCollection) {
        this.weredasCollection = weredasCollection;
    }

    @XmlTransient
    public Collection<Yigbagnayigbagnmels> getYigbagnayigbagnmelsCollection() {
        return yigbagnayigbagnmelsCollection;
    }

    public void setYigbagnayigbagnmelsCollection(Collection<Yigbagnayigbagnmels> yigbagnayigbagnmelsCollection) {
        this.yigbagnayigbagnmelsCollection = yigbagnayigbagnmelsCollection;
    }

    @XmlTransient
    public Collection<Yigbagnayigbagnmels> getYigbagnayigbagnmelsCollection1() {
        return yigbagnayigbagnmelsCollection1;
    }

    public void setYigbagnayigbagnmelsCollection1(Collection<Yigbagnayigbagnmels> yigbagnayigbagnmelsCollection1) {
        this.yigbagnayigbagnmelsCollection1 = yigbagnayigbagnmelsCollection1;
    }

    @XmlTransient
    public Collection<Yigbagnayigbagnmels> getYigbagnayigbagnmelsCollection2() {
        return yigbagnayigbagnmelsCollection2;
    }

    public void setYigbagnayigbagnmelsCollection2(Collection<Yigbagnayigbagnmels> yigbagnayigbagnmelsCollection2) {
        this.yigbagnayigbagnmelsCollection2 = yigbagnayigbagnmelsCollection2;
    }

    @XmlTransient
    public Collection<Meritizazandabetuta> getMeritizazandabetutaCollection() {
        return meritizazandabetutaCollection;
    }

    public void setMeritizazandabetutaCollection(Collection<Meritizazandabetuta> meritizazandabetutaCollection) {
        this.meritizazandabetutaCollection = meritizazandabetutaCollection;
    }

    @XmlTransient
    public Collection<Meritizazandabetuta> getMeritizazandabetutaCollection1() {
        return meritizazandabetutaCollection1;
    }

    public void setMeritizazandabetutaCollection1(Collection<Meritizazandabetuta> meritizazandabetutaCollection1) {
        this.meritizazandabetutaCollection1 = meritizazandabetutaCollection1;
    }

    @XmlTransient
    public Collection<Wenjelmezgebkedamimrmra> getWenjelmezgebkedamimrmraCollection() {
        return wenjelmezgebkedamimrmraCollection;
    }

    public void setWenjelmezgebkedamimrmraCollection(Collection<Wenjelmezgebkedamimrmra> wenjelmezgebkedamimrmraCollection) {
        this.wenjelmezgebkedamimrmraCollection = wenjelmezgebkedamimrmraCollection;
    }

    @XmlTransient
    public Collection<Wenjelmezgebkedamimrmra> getWenjelmezgebkedamimrmraCollection1() {
        return wenjelmezgebkedamimrmraCollection1;
    }

    public void setWenjelmezgebkedamimrmraCollection1(Collection<Wenjelmezgebkedamimrmra> wenjelmezgebkedamimrmraCollection1) {
        this.wenjelmezgebkedamimrmraCollection1 = wenjelmezgebkedamimrmraCollection1;
    }

    @XmlTransient
    public Collection<Wenjelmezgebkedamimrmra> getWenjelmezgebkedamimrmraCollection2() {
        return wenjelmezgebkedamimrmraCollection2;
    }

    public void setWenjelmezgebkedamimrmraCollection2(Collection<Wenjelmezgebkedamimrmra> wenjelmezgebkedamimrmraCollection2) {
        this.wenjelmezgebkedamimrmraCollection2 = wenjelmezgebkedamimrmraCollection2;
    }

    public Regions getRegionid() {
        return regionid;
    }

    public void setRegionid(Regions regionid) {
        this.regionid = regionid;
    }

    @XmlTransient
    public Collection<Mebtnatkmmyefetabherafetatem> getMebtnatkmmyefetabherafetatemCollection() {
        return mebtnatkmmyefetabherafetatemCollection;
    }

    public void setMebtnatkmmyefetabherafetatemCollection(Collection<Mebtnatkmmyefetabherafetatem> mebtnatkmmyefetabherafetatemCollection) {
        this.mebtnatkmmyefetabherafetatemCollection = mebtnatkmmyefetabherafetatemCollection;
    }

    @XmlTransient
    public Collection<Mebtnatkmmyefetabherafetatem> getMebtnatkmmyefetabherafetatemCollection1() {
        return mebtnatkmmyefetabherafetatemCollection1;
    }

    public void setMebtnatkmmyefetabherafetatemCollection1(Collection<Mebtnatkmmyefetabherafetatem> mebtnatkmmyefetabherafetatemCollection1) {
        this.mebtnatkmmyefetabherafetatemCollection1 = mebtnatkmmyefetabherafetatemCollection1;
    }

    @XmlTransient
    public Collection<Mebtnatkmmyefetabherafetatem> getMebtnatkmmyefetabherafetatemCollection2() {
        return mebtnatkmmyefetabherafetatemCollection2;
    }

    public void setMebtnatkmmyefetabherafetatemCollection2(Collection<Mebtnatkmmyefetabherafetatem> mebtnatkmmyefetabherafetatemCollection2) {
        this.mebtnatkmmyefetabherafetatemCollection2 = mebtnatkmmyefetabherafetatemCollection2;
    }

    @XmlTransient
    public Collection<Wengelabetuta> getWengelabetutaCollection() {
        return wengelabetutaCollection;
    }

    public void setWengelabetutaCollection(Collection<Wengelabetuta> wengelabetutaCollection) {
        this.wengelabetutaCollection = wengelabetutaCollection;
    }

    @XmlTransient
    public Collection<Wengelabetuta> getWengelabetutaCollection1() {
        return wengelabetutaCollection1;
    }

    public void setWengelabetutaCollection1(Collection<Wengelabetuta> wengelabetutaCollection1) {
        this.wengelabetutaCollection1 = wengelabetutaCollection1;
    }

    @XmlTransient
    public Collection<Qettegnakisandkesemelsmezgeb> getQettegnakisandkesemelsmezgebCollection() {
        return qettegnakisandkesemelsmezgebCollection;
    }

    public void setQettegnakisandkesemelsmezgebCollection(Collection<Qettegnakisandkesemelsmezgeb> qettegnakisandkesemelsmezgebCollection) {
        this.qettegnakisandkesemelsmezgebCollection = qettegnakisandkesemelsmezgebCollection;
    }

    @XmlTransient
    public Collection<Qettegnakisandkesemelsmezgeb> getQettegnakisandkesemelsmezgebCollection1() {
        return qettegnakisandkesemelsmezgebCollection1;
    }

    public void setQettegnakisandkesemelsmezgebCollection1(Collection<Qettegnakisandkesemelsmezgeb> qettegnakisandkesemelsmezgebCollection1) {
        this.qettegnakisandkesemelsmezgebCollection1 = qettegnakisandkesemelsmezgebCollection1;
    }

    @XmlTransient
    public Collection<Qettegnakisandkesemelsmezgeb> getQettegnakisandkesemelsmezgebCollection2() {
        return qettegnakisandkesemelsmezgebCollection2;
    }

    public void setQettegnakisandkesemelsmezgebCollection2(Collection<Qettegnakisandkesemelsmezgeb> qettegnakisandkesemelsmezgebCollection2) {
        this.qettegnakisandkesemelsmezgebCollection2 = qettegnakisandkesemelsmezgebCollection2;
    }

    @XmlTransient
    public Collection<Senedochenatebekoch> getSenedochenatebekochCollection() {
        return senedochenatebekochCollection;
    }

    public void setSenedochenatebekochCollection(Collection<Senedochenatebekoch> senedochenatebekochCollection) {
        this.senedochenatebekochCollection = senedochenatebekochCollection;
    }

    @XmlTransient
    public Collection<Wengelwastna> getWengelwastnaCollection() {
        return wengelwastnaCollection;
    }

    public void setWengelwastnaCollection(Collection<Wengelwastna> wengelwastnaCollection) {
        this.wengelwastnaCollection = wengelwastnaCollection;
    }

    @XmlTransient
    public Collection<Wengelwastna> getWengelwastnaCollection1() {
        return wengelwastnaCollection1;
    }

    public void setWengelwastnaCollection1(Collection<Wengelwastna> wengelwastnaCollection1) {
        this.wengelwastnaCollection1 = wengelwastnaCollection1;
    }

    @XmlTransient
    public Collection<Wengelwastna> getWengelwastnaCollection2() {
        return wengelwastnaCollection2;
    }

    public void setWengelwastnaCollection2(Collection<Wengelwastna> wengelwastnaCollection2) {
        this.wengelwastnaCollection2 = wengelwastnaCollection2;
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
        if (!(object instanceof Zones)) {
            return false;
        }
        Zones other = (Zones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return zonename;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
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
