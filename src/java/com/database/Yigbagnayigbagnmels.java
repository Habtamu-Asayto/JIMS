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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fedlu
 */
@Entity
@Table(name = "yigbagnayigbagnmels")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Yigbagnayigbagnmels.findAll", query = "SELECT y FROM Yigbagnayigbagnmels y"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findById", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.id = :id"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findByFayluyetekemetebetbota", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.fayluyetekemetebetbota = :fayluyetekemetebetbota"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findByGetbzat", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.getbzat = :getbzat"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findByKebele", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.kebele = :kebele"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findByKesashdrgtname", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.kesashdrgtname = :kesashdrgtname"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findByKesashfname", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.kesashfname = :kesashfname"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findByKesashlastname", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.kesashlastname = :kesashlastname"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findByKesashname", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.kesashname = :kesashname"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findByKetero", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.ketero = :ketero"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findByKsashaynet", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.ksashaynet = :ksashaynet"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findByMezgebkutr", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.mezgebkutr = :mezgebkutr"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findByMezgebuyetekefetebetken", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.mezgebuyetekefetebetken = :mezgebuyetekefetebetken"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findByMezgebuyetewesenebetken", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.mezgebuyetewesenebetken = :mezgebuyetewesenebetken"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findByTekesashdrgtname", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.tekesashdrgtname = :tekesashdrgtname"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findByTekesashfname", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.tekesashfname = :tekesashfname"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findByTekesashlastname", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.tekesashlastname = :tekesashlastname"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findByTekesashname", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.tekesashname = :tekesashname"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findByYeabkmeftabhermezgebkutr", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.yeabkmeftabhermezgebkutr = :yeabkmeftabhermezgebkutr"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findByYeabkmeyigbagnmezgebkutr", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.yeabkmeyigbagnmezgebkutr = :yeabkmeyigbagnmezgebkutr"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findByYefrdbetmeleyakutr", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.yefrdbetmeleyakutr = :yefrdbetmeleyakutr"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findByYefrdbetusim", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.yefrdbetusim = :yefrdbetusim"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findByYegenzebumeten", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.yegenzebumeten = :yegenzebumeten"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findByYegudauaynet", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.yegudauaynet = :yegudauaynet"),
    @NamedQuery(name = "Yigbagnayigbagnmels.findByYetekesashaynet", query = "SELECT y FROM Yigbagnayigbagnmels y WHERE y.yetekesashaynet = :yetekesashaynet")})
public class Yigbagnayigbagnmels implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "fayluyetekemetebetbota")
    private String fayluyetekemetebetbota;
    @Size(max = 200)
    @Column(name = "getbzat")
    private String getbzat;
    @Size(max = 200)
    @Column(name = "kebele")
    private String kebele;
    @Size(max = 200)
    @Column(name = "kesashdrgtname")
    private String kesashdrgtname;
    @Size(max = 200)
    @Column(name = "kesashfname")
    private String kesashfname;
    @Size(max = 200)
    @Column(name = "kesashlastname")
    private String kesashlastname;
    @Size(max = 200)
    @Column(name = "kesashname")
    private String kesashname;
    @Size(max = 200)
    @Column(name = "ketero")
    private String ketero;
    @Size(max = 200)
    @Column(name = "ksashaynet")
    private String ksashaynet;
    @Size(max = 200)
    @Column(name = "mezgebkutr")
    private String mezgebkutr;
    @Size(max = 200)
    @Column(name = "mezgebuyetekefetebetken")
    private String mezgebuyetekefetebetken;
    @Size(max = 200)
    @Column(name = "mezgebuyetewesenebetken")
    private String mezgebuyetewesenebetken;
    @Size(max = 200)
    @Column(name = "tekesashdrgtname")
    private String tekesashdrgtname;
    @Size(max = 200)
    @Column(name = "tekesashfname")
    private String tekesashfname;
    @Size(max = 200)
    @Column(name = "tekesashlastname")
    private String tekesashlastname;
    @Size(max = 200)
    @Column(name = "tekesashname")
    private String tekesashname;
    @Size(max = 200)
    @Column(name = "yeabkmeftabhermezgebkutr")
    private String yeabkmeftabhermezgebkutr;
    @Size(max = 200)
    @Column(name = "yeabkmeyigbagnmezgebkutr")
    private String yeabkmeyigbagnmezgebkutr;
    @Size(max = 200)
    @Column(name = "yefrdbetmeleyakutr")
    private String yefrdbetmeleyakutr;
    @Size(max = 200)
    @Column(name = "yefrdbetusim")
    private String yefrdbetusim;
    @Size(max = 200)
    @Column(name = "yegenzebumeten")
    private String yegenzebumeten;
    @Size(max = 200)
    @Column(name = "yegudauaynet")
    private String yegudauaynet;
    @Size(max = 200)
    @Column(name = "yetekesashaynet")
    private String yetekesashaynet;
    @JoinColumn(name = "kesashregionid", referencedColumnName = "id")
    @ManyToOne
    private Regions kesashregionid;
    @JoinColumn(name = "region", referencedColumnName = "id")
    @ManyToOne
    private Regions region;
    @JoinColumn(name = "tekesashregionid", referencedColumnName = "id")
    @ManyToOne
    private Regions tekesashregionid;
    @JoinColumn(name = "kesashweredaid", referencedColumnName = "id")
    @ManyToOne
    private Weredas kesashweredaid;
    @JoinColumn(name = "tekesashweredaid", referencedColumnName = "id")
    @ManyToOne
    private Weredas tekesashweredaid;
    @JoinColumn(name = "woreda", referencedColumnName = "id")
    @ManyToOne
    private Weredas woreda;
    @JoinColumn(name = "kesashzoneid", referencedColumnName = "id")
    @ManyToOne
    private Zones kesashzoneid;
    @JoinColumn(name = "tekesashzoneid", referencedColumnName = "id")
    @ManyToOne
    private Zones tekesashzoneid;
    @JoinColumn(name = "zone", referencedColumnName = "id")
    @ManyToOne
    private Zones zone;

    public Yigbagnayigbagnmels() {
    }

    public Yigbagnayigbagnmels(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFayluyetekemetebetbota() {
        return fayluyetekemetebetbota;
    }

    public void setFayluyetekemetebetbota(String fayluyetekemetebetbota) {
        this.fayluyetekemetebetbota = fayluyetekemetebetbota;
    }

    public String getGetbzat() {
        return getbzat;
    }

    public void setGetbzat(String getbzat) {
        this.getbzat = getbzat;
    }

    public String getKebele() {
        return kebele;
    }

    public void setKebele(String kebele) {
        this.kebele = kebele;
    }

    public String getKesashdrgtname() {
        return kesashdrgtname;
    }

    public void setKesashdrgtname(String kesashdrgtname) {
        this.kesashdrgtname = kesashdrgtname;
    }

    public String getKesashfname() {
        return kesashfname;
    }

    public void setKesashfname(String kesashfname) {
        this.kesashfname = kesashfname;
    }

    public String getKesashlastname() {
        return kesashlastname;
    }

    public void setKesashlastname(String kesashlastname) {
        this.kesashlastname = kesashlastname;
    }

    public String getKesashname() {
        return kesashname;
    }

    public void setKesashname(String kesashname) {
        this.kesashname = kesashname;
    }

    public String getKetero() {
        return ketero;
    }

    public void setKetero(String ketero) {
        this.ketero = ketero;
    }

    public String getKsashaynet() {
        return ksashaynet;
    }

    public void setKsashaynet(String ksashaynet) {
        this.ksashaynet = ksashaynet;
    }

    public String getMezgebkutr() {
        return mezgebkutr;
    }

    public void setMezgebkutr(String mezgebkutr) {
        this.mezgebkutr = mezgebkutr;
    }

    public String getMezgebuyetekefetebetken() {
        return mezgebuyetekefetebetken;
    }

    public void setMezgebuyetekefetebetken(String mezgebuyetekefetebetken) {
        this.mezgebuyetekefetebetken = mezgebuyetekefetebetken;
    }

    public String getMezgebuyetewesenebetken() {
        return mezgebuyetewesenebetken;
    }

    public void setMezgebuyetewesenebetken(String mezgebuyetewesenebetken) {
        this.mezgebuyetewesenebetken = mezgebuyetewesenebetken;
    }

    public String getTekesashdrgtname() {
        return tekesashdrgtname;
    }

    public void setTekesashdrgtname(String tekesashdrgtname) {
        this.tekesashdrgtname = tekesashdrgtname;
    }

    public String getTekesashfname() {
        return tekesashfname;
    }

    public void setTekesashfname(String tekesashfname) {
        this.tekesashfname = tekesashfname;
    }

    public String getTekesashlastname() {
        return tekesashlastname;
    }

    public void setTekesashlastname(String tekesashlastname) {
        this.tekesashlastname = tekesashlastname;
    }

    public String getTekesashname() {
        return tekesashname;
    }

    public void setTekesashname(String tekesashname) {
        this.tekesashname = tekesashname;
    }

    public String getYeabkmeftabhermezgebkutr() {
        return yeabkmeftabhermezgebkutr;
    }

    public void setYeabkmeftabhermezgebkutr(String yeabkmeftabhermezgebkutr) {
        this.yeabkmeftabhermezgebkutr = yeabkmeftabhermezgebkutr;
    }

    public String getYeabkmeyigbagnmezgebkutr() {
        return yeabkmeyigbagnmezgebkutr;
    }

    public void setYeabkmeyigbagnmezgebkutr(String yeabkmeyigbagnmezgebkutr) {
        this.yeabkmeyigbagnmezgebkutr = yeabkmeyigbagnmezgebkutr;
    }

    public String getYefrdbetmeleyakutr() {
        return yefrdbetmeleyakutr;
    }

    public void setYefrdbetmeleyakutr(String yefrdbetmeleyakutr) {
        this.yefrdbetmeleyakutr = yefrdbetmeleyakutr;
    }

    public String getYefrdbetusim() {
        return yefrdbetusim;
    }

    public void setYefrdbetusim(String yefrdbetusim) {
        this.yefrdbetusim = yefrdbetusim;
    }

    public String getYegenzebumeten() {
        return yegenzebumeten;
    }

    public void setYegenzebumeten(String yegenzebumeten) {
        this.yegenzebumeten = yegenzebumeten;
    }

    public String getYegudauaynet() {
        return yegudauaynet;
    }

    public void setYegudauaynet(String yegudauaynet) {
        this.yegudauaynet = yegudauaynet;
    }

    public String getYetekesashaynet() {
        return yetekesashaynet;
    }

    public void setYetekesashaynet(String yetekesashaynet) {
        this.yetekesashaynet = yetekesashaynet;
    }

    public Regions getKesashregionid() {
        return kesashregionid;
    }

    public void setKesashregionid(Regions kesashregionid) {
        this.kesashregionid = kesashregionid;
    }

    public Regions getRegion() {
        return region;
    }

    public void setRegion(Regions region) {
        this.region = region;
    }

    public Regions getTekesashregionid() {
        return tekesashregionid;
    }

    public void setTekesashregionid(Regions tekesashregionid) {
        this.tekesashregionid = tekesashregionid;
    }

    public Weredas getKesashweredaid() {
        return kesashweredaid;
    }

    public void setKesashweredaid(Weredas kesashweredaid) {
        this.kesashweredaid = kesashweredaid;
    }

    public Weredas getTekesashweredaid() {
        return tekesashweredaid;
    }

    public void setTekesashweredaid(Weredas tekesashweredaid) {
        this.tekesashweredaid = tekesashweredaid;
    }

    public Weredas getWoreda() {
        return woreda;
    }

    public void setWoreda(Weredas woreda) {
        this.woreda = woreda;
    }

    public Zones getKesashzoneid() {
        return kesashzoneid;
    }

    public void setKesashzoneid(Zones kesashzoneid) {
        this.kesashzoneid = kesashzoneid;
    }

    public Zones getTekesashzoneid() {
        return tekesashzoneid;
    }

    public void setTekesashzoneid(Zones tekesashzoneid) {
        this.tekesashzoneid = tekesashzoneid;
    }

    public Zones getZone() {
        return zone;
    }

    public void setZone(Zones zone) {
        this.zone = zone;
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
        if (!(object instanceof Yigbagnayigbagnmels)) {
            return false;
        }
        Yigbagnayigbagnmels other = (Yigbagnayigbagnmels) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.databse.Yigbagnayigbagnmels[ id=" + id + " ]";
    }
    
}
