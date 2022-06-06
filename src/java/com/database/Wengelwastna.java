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
@Table(name = "wengelwastna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wengelwastna.findAll", query = "SELECT w FROM Wengelwastna w"),
    @NamedQuery(name = "Wengelwastna.findById", query = "SELECT w FROM Wengelwastna w WHERE w.id = :id"),
    @NamedQuery(name = "Wengelwastna.findByKebele", query = "SELECT w FROM Wengelwastna w WHERE w.kebele = :kebele"),
    @NamedQuery(name = "Wengelwastna.findByMezgebkutr", query = "SELECT w FROM Wengelwastna w WHERE w.mezgebkutr = :mezgebkutr"),
    @NamedQuery(name = "Wengelwastna.findByFthbiromeleyakutr", query = "SELECT w FROM Wengelwastna w WHERE w.fthbiromeleyakutr = :fthbiromeleyakutr"),
    @NamedQuery(name = "Wengelwastna.findByYzonesim", query = "SELECT w FROM Wengelwastna w WHERE w.yzonesim = :yzonesim"),
    @NamedQuery(name = "Wengelwastna.findByYeweredafrdbetsim", query = "SELECT w FROM Wengelwastna w WHERE w.yeweredafrdbetsim = :yeweredafrdbetsim"),
    @NamedQuery(name = "Wengelwastna.findByYpolisesem", query = "SELECT w FROM Wengelwastna w WHERE w.ypolisesem = :ypolisesem"),
    @NamedQuery(name = "Wengelwastna.findByYepolisewnjelmrmerameleyakutr", query = "SELECT w FROM Wengelwastna w WHERE w.yepolisewnjelmrmerameleyakutr = :yepolisewnjelmrmerameleyakutr"),
    @NamedQuery(name = "Wengelwastna.findByKsashaynet", query = "SELECT w FROM Wengelwastna w WHERE w.ksashaynet = :ksashaynet"),
    @NamedQuery(name = "Wengelwastna.findByKesashdrgtname", query = "SELECT w FROM Wengelwastna w WHERE w.kesashdrgtname = :kesashdrgtname"),
    @NamedQuery(name = "Wengelwastna.findByKesashname", query = "SELECT w FROM Wengelwastna w WHERE w.kesashname = :kesashname"),
    @NamedQuery(name = "Wengelwastna.findByKesashfname", query = "SELECT w FROM Wengelwastna w WHERE w.kesashfname = :kesashfname"),
    @NamedQuery(name = "Wengelwastna.findByKesashlastname", query = "SELECT w FROM Wengelwastna w WHERE w.kesashlastname = :kesashlastname"),
    @NamedQuery(name = "Wengelwastna.findByYetekesashaynet", query = "SELECT w FROM Wengelwastna w WHERE w.yetekesashaynet = :yetekesashaynet"),
    @NamedQuery(name = "Wengelwastna.findByTekesashdrgtname", query = "SELECT w FROM Wengelwastna w WHERE w.tekesashdrgtname = :tekesashdrgtname"),
    @NamedQuery(name = "Wengelwastna.findByTekesashname", query = "SELECT w FROM Wengelwastna w WHERE w.tekesashname = :tekesashname"),
    @NamedQuery(name = "Wengelwastna.findByTekesashfname", query = "SELECT w FROM Wengelwastna w WHERE w.tekesashfname = :tekesashfname"),
    @NamedQuery(name = "Wengelwastna.findByTekesashlastname", query = "SELECT w FROM Wengelwastna w WHERE w.tekesashlastname = :tekesashlastname"),
    @NamedQuery(name = "Wengelwastna.findByYewenjeluaynet", query = "SELECT w FROM Wengelwastna w WHERE w.yewenjeluaynet = :yewenjeluaynet"),
    @NamedQuery(name = "Wengelwastna.findByKetero", query = "SELECT w FROM Wengelwastna w WHERE w.ketero = :ketero"),
    @NamedQuery(name = "Wengelwastna.findByFayluyetekemetebetbota", query = "SELECT w FROM Wengelwastna w WHERE w.fayluyetekemetebetbota = :fayluyetekemetebetbota"),
    @NamedQuery(name = "Wengelwastna.findByGetbzat", query = "SELECT w FROM Wengelwastna w WHERE w.getbzat = :getbzat"),
    @NamedQuery(name = "Wengelwastna.findByMezgebuyetekefetebetken", query = "SELECT w FROM Wengelwastna w WHERE w.mezgebuyetekefetebetken = :mezgebuyetekefetebetken"),
    @NamedQuery(name = "Wengelwastna.findByZonekutr", query = "SELECT w FROM Wengelwastna w WHERE w.zonekutr = :zonekutr"),
    @NamedQuery(name = "Wengelwastna.findByWeredakutr", query = "SELECT w FROM Wengelwastna w WHERE w.weredakutr = :weredakutr"),
    @NamedQuery(name = "Wengelwastna.findByPolicekutr", query = "SELECT w FROM Wengelwastna w WHERE w.policekutr = :policekutr"),
    @NamedQuery(name = "Wengelwastna.findByFitihbitokutr", query = "SELECT w FROM Wengelwastna w WHERE w.fitihbitokutr = :fitihbitokutr"),
    @NamedQuery(name = "Wengelwastna.findByFilepath", query = "SELECT w FROM Wengelwastna w WHERE w.filepath = :filepath"),
    @NamedQuery(name = "Wengelwastna.findByRegby", query = "SELECT w FROM Wengelwastna w WHERE w.regby = :regby"),
    @NamedQuery(name = "Wengelwastna.findByUpdatedby", query = "SELECT w FROM Wengelwastna w WHERE w.updatedby = :updatedby"),
    @NamedQuery(name = "Wengelwastna.findBySeason", query = "SELECT w FROM Wengelwastna w WHERE w.season = :season")})
public class Wengelwastna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "kebele")
    private String kebele;
    @Size(max = 200)
    @Column(name = "mezgebkutr")
    private String mezgebkutr;
    @Size(max = 200)
    @Column(name = "fthbiromeleyakutr")
    private String fthbiromeleyakutr;
    @Size(max = 200)
    @Column(name = "yzonesim")
    private String yzonesim;
    @Size(max = 200)
    @Column(name = "yeweredafrdbetsim")
    private String yeweredafrdbetsim;
    @Size(max = 200)
    @Column(name = "ypolisesem")
    private String ypolisesem;
    @Size(max = 200)
    @Column(name = "yepolisewnjelmrmerameleyakutr")
    private String yepolisewnjelmrmerameleyakutr;
    @Size(max = 200)
    @Column(name = "ksashaynet")
    private String ksashaynet;
    @Size(max = 200)
    @Column(name = "kesashdrgtname")
    private String kesashdrgtname;
    @Size(max = 200)
    @Column(name = "kesashname")
    private String kesashname;
    @Size(max = 200)
    @Column(name = "kesashfname")
    private String kesashfname;
    @Size(max = 200)
    @Column(name = "kesashlastname")
    private String kesashlastname;
    @Size(max = 200)
    @Column(name = "yetekesashaynet")
    private String yetekesashaynet;
    @Size(max = 200)
    @Column(name = "tekesashdrgtname")
    private String tekesashdrgtname;
    @Size(max = 200)
    @Column(name = "tekesashname")
    private String tekesashname;
    @Size(max = 200)
    @Column(name = "tekesashfname")
    private String tekesashfname;
    @Size(max = 200)
    @Column(name = "tekesashlastname")
    private String tekesashlastname;
    @Size(max = 200)
    @Column(name = "yewenjeluaynet")
    private String yewenjeluaynet;
    @Size(max = 200)
    @Column(name = "ketero")
    private String ketero;
    @Size(max = 200)
    @Column(name = "fayluyetekemetebetbota")
    private String fayluyetekemetebetbota;
    @Size(max = 200)
    @Column(name = "getbzat")
    private String getbzat;
    @Size(max = 200)
    @Column(name = "mezgebuyetekefetebetken")
    private String mezgebuyetekefetebetken;
    @Size(max = 200)
    @Column(name = "zonekutr")
    private String zonekutr;
    @Size(max = 200)
    @Column(name = "weredakutr")
    private String weredakutr;
    @Size(max = 200)
    @Column(name = "policekutr")
    private String policekutr;
    @Size(max = 200)
    @Column(name = "fitihbitokutr")
    private String fitihbitokutr;
    @Size(max = 200)
    @Column(name = "filepath")
    private String filepath;
    @Size(max = 200)
    @Column(name = "regby")
    private String regby;
    @Size(max = 200)
    @Column(name = "updatedby")
    private String updatedby;
    @Size(max = 200)
    @Column(name = "season")
    private String season;
    @JoinColumn(name = "kesashregionid", referencedColumnName = "id")
    @ManyToOne
    private Regions kesashregionid;
    @JoinColumn(name = "regionid", referencedColumnName = "id")
    @ManyToOne
    private Regions regionid;
    @JoinColumn(name = "tekesashregionid", referencedColumnName = "id")
    @ManyToOne
    private Regions tekesashregionid;
    @JoinColumn(name = "kesashweredaid", referencedColumnName = "id")
    @ManyToOne
    private Weredas kesashweredaid;
    @JoinColumn(name = "tekesashweredaid", referencedColumnName = "id")
    @ManyToOne
    private Weredas tekesashweredaid;
    @JoinColumn(name = "woredaid", referencedColumnName = "id")
    @ManyToOne
    private Weredas woredaid;
    @JoinColumn(name = "kesashzoneid", referencedColumnName = "id")
    @ManyToOne
    private Zones kesashzoneid;
    @JoinColumn(name = "tekesashzoneid", referencedColumnName = "id")
    @ManyToOne
    private Zones tekesashzoneid;
    @JoinColumn(name = "zoneid", referencedColumnName = "id")
    @ManyToOne
    private Zones zoneid;

    public Wengelwastna() {
    }

    public Wengelwastna(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKebele() {
        return kebele;
    }

    public void setKebele(String kebele) {
        this.kebele = kebele;
    }

    public String getMezgebkutr() {
        return mezgebkutr;
    }

    public void setMezgebkutr(String mezgebkutr) {
        this.mezgebkutr = mezgebkutr;
    }

    public String getFthbiromeleyakutr() {
        return fthbiromeleyakutr;
    }

    public void setFthbiromeleyakutr(String fthbiromeleyakutr) {
        this.fthbiromeleyakutr = fthbiromeleyakutr;
    }

    public String getYzonesim() {
        return yzonesim;
    }

    public void setYzonesim(String yzonesim) {
        this.yzonesim = yzonesim;
    }

    public String getYeweredafrdbetsim() {
        return yeweredafrdbetsim;
    }

    public void setYeweredafrdbetsim(String yeweredafrdbetsim) {
        this.yeweredafrdbetsim = yeweredafrdbetsim;
    }

    public String getYpolisesem() {
        return ypolisesem;
    }

    public void setYpolisesem(String ypolisesem) {
        this.ypolisesem = ypolisesem;
    }

    public String getYepolisewnjelmrmerameleyakutr() {
        return yepolisewnjelmrmerameleyakutr;
    }

    public void setYepolisewnjelmrmerameleyakutr(String yepolisewnjelmrmerameleyakutr) {
        this.yepolisewnjelmrmerameleyakutr = yepolisewnjelmrmerameleyakutr;
    }

    public String getKsashaynet() {
        return ksashaynet;
    }

    public void setKsashaynet(String ksashaynet) {
        this.ksashaynet = ksashaynet;
    }

    public String getKesashdrgtname() {
        return kesashdrgtname;
    }

    public void setKesashdrgtname(String kesashdrgtname) {
        this.kesashdrgtname = kesashdrgtname;
    }

    public String getKesashname() {
        return kesashname;
    }

    public void setKesashname(String kesashname) {
        this.kesashname = kesashname;
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

    public String getYetekesashaynet() {
        return yetekesashaynet;
    }

    public void setYetekesashaynet(String yetekesashaynet) {
        this.yetekesashaynet = yetekesashaynet;
    }

    public String getTekesashdrgtname() {
        return tekesashdrgtname;
    }

    public void setTekesashdrgtname(String tekesashdrgtname) {
        this.tekesashdrgtname = tekesashdrgtname;
    }

    public String getTekesashname() {
        return tekesashname;
    }

    public void setTekesashname(String tekesashname) {
        this.tekesashname = tekesashname;
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

    public String getYewenjeluaynet() {
        return yewenjeluaynet;
    }

    public void setYewenjeluaynet(String yewenjeluaynet) {
        this.yewenjeluaynet = yewenjeluaynet;
    }

    public String getKetero() {
        return ketero;
    }

    public void setKetero(String ketero) {
        this.ketero = ketero;
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

    public String getMezgebuyetekefetebetken() {
        return mezgebuyetekefetebetken;
    }

    public void setMezgebuyetekefetebetken(String mezgebuyetekefetebetken) {
        this.mezgebuyetekefetebetken = mezgebuyetekefetebetken;
    }

    public String getZonekutr() {
        return zonekutr;
    }

    public void setZonekutr(String zonekutr) {
        this.zonekutr = zonekutr;
    }

    public String getWeredakutr() {
        return weredakutr;
    }

    public void setWeredakutr(String weredakutr) {
        this.weredakutr = weredakutr;
    }

    public String getPolicekutr() {
        return policekutr;
    }

    public void setPolicekutr(String policekutr) {
        this.policekutr = policekutr;
    }

    public String getFitihbitokutr() {
        return fitihbitokutr;
    }

    public void setFitihbitokutr(String fitihbitokutr) {
        this.fitihbitokutr = fitihbitokutr;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getRegby() {
        return regby;
    }

    public void setRegby(String regby) {
        this.regby = regby;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Regions getKesashregionid() {
        return kesashregionid;
    }

    public void setKesashregionid(Regions kesashregionid) {
        this.kesashregionid = kesashregionid;
    }

    public Regions getRegionid() {
        return regionid;
    }

    public void setRegionid(Regions regionid) {
        this.regionid = regionid;
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

    public Weredas getWoredaid() {
        return woredaid;
    }

    public void setWoredaid(Weredas woredaid) {
        this.woredaid = woredaid;
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

    public Zones getZoneid() {
        return zoneid;
    }

    public void setZoneid(Zones zoneid) {
        this.zoneid = zoneid;
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
        if (!(object instanceof Wengelwastna)) {
            return false;
        }
        Wengelwastna other = (Wengelwastna) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.databse.Wengelwastna[ id=" + id + " ]";
    }
    
}
