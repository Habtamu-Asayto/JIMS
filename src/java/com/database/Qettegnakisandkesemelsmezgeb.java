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
@Table(name = "qettegnakisandkesemelsmezgeb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findAll", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findById", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.id = :id"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByKebele", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.kebele = :kebele"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByMezgebkutr", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.mezgebkutr = :mezgebkutr"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByYzoonfrdbetsem", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.yzoonfrdbetsem = :yzoonfrdbetsem"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByYftabhermezgebkutr", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.yftabhermezgebkutr = :yftabhermezgebkutr"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByYabkmemezgebkutr", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.yabkmemezgebkutr = :yabkmemezgebkutr"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByKsashaynet", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.ksashaynet = :ksashaynet"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByKesashdrgtname", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.kesashdrgtname = :kesashdrgtname"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByKesashname", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.kesashname = :kesashname"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByKesashfname", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.kesashfname = :kesashfname"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByKesashlastname", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.kesashlastname = :kesashlastname"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByYetekesashaynet", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.yetekesashaynet = :yetekesashaynet"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByTekesashdrgtname", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.tekesashdrgtname = :tekesashdrgtname"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByTekesashname", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.tekesashname = :tekesashname"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByTekesashfname", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.tekesashfname = :tekesashfname"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByTekesashlastname", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.tekesashlastname = :tekesashlastname"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByYegudayuaynet", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.yegudayuaynet = :yegudayuaynet"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByYegenzebumeten", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.yegenzebumeten = :yegenzebumeten"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByFayluyetekefetebetken", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.fayluyetekefetebetken = :fayluyetekefetebetken"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByFayluyetekemetebetbota", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.fayluyetekemetebetbota = :fayluyetekemetebetbota"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByGetbzat", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.getbzat = :getbzat"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByMezgebuyetewesenebetken", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.mezgebuyetewesenebetken = :mezgebuyetewesenebetken"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByKetero", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.ketero = :ketero"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByRegby", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.regby = :regby"),
    @NamedQuery(name = "Qettegnakisandkesemelsmezgeb.findByUpdatedby", query = "SELECT q FROM Qettegnakisandkesemelsmezgeb q WHERE q.updatedby = :updatedby")})
public class Qettegnakisandkesemelsmezgeb implements Serializable {

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
    @Column(name = "yzoonfrdbetsem")
    private String yzoonfrdbetsem;
    @Size(max = 200)
    @Column(name = "yftabhermezgebkutr")
    private String yftabhermezgebkutr;
    @Size(max = 200)
    @Column(name = "yabkmemezgebkutr")
    private String yabkmemezgebkutr;
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
    @Column(name = "yegudayuaynet")
    private String yegudayuaynet;
    @Size(max = 200)
    @Column(name = "yegenzebumeten")
    private String yegenzebumeten;
    @Size(max = 200)
    @Column(name = "fayluyetekefetebetken")
    private String fayluyetekefetebetken;
    @Size(max = 200)
    @Column(name = "fayluyetekemetebetbota")
    private String fayluyetekemetebetbota;
    @Size(max = 200)
    @Column(name = "getbzat")
    private String getbzat;
    @Size(max = 200)
    @Column(name = "mezgebuyetewesenebetken")
    private String mezgebuyetewesenebetken;
    @Size(max = 200)
    @Column(name = "ketero")
    private String ketero;
    @Size(max = 200)
    @Column(name = "regby")
    private String regby;
    @Size(max = 20)
    @Column(name = "updatedby")
    private String updatedby;
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

    public Qettegnakisandkesemelsmezgeb() {
    }

    public Qettegnakisandkesemelsmezgeb(Integer id) {
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

    public String getYzoonfrdbetsem() {
        return yzoonfrdbetsem;
    }

    public void setYzoonfrdbetsem(String yzoonfrdbetsem) {
        this.yzoonfrdbetsem = yzoonfrdbetsem;
    }

    public String getYftabhermezgebkutr() {
        return yftabhermezgebkutr;
    }

    public void setYftabhermezgebkutr(String yftabhermezgebkutr) {
        this.yftabhermezgebkutr = yftabhermezgebkutr;
    }

    public String getYabkmemezgebkutr() {
        return yabkmemezgebkutr;
    }

    public void setYabkmemezgebkutr(String yabkmemezgebkutr) {
        this.yabkmemezgebkutr = yabkmemezgebkutr;
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

    public String getYegudayuaynet() {
        return yegudayuaynet;
    }

    public void setYegudayuaynet(String yegudayuaynet) {
        this.yegudayuaynet = yegudayuaynet;
    }

    public String getYegenzebumeten() {
        return yegenzebumeten;
    }

    public void setYegenzebumeten(String yegenzebumeten) {
        this.yegenzebumeten = yegenzebumeten;
    }

    public String getFayluyetekefetebetken() {
        return fayluyetekefetebetken;
    }

    public void setFayluyetekefetebetken(String fayluyetekefetebetken) {
        this.fayluyetekefetebetken = fayluyetekefetebetken;
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

    public String getMezgebuyetewesenebetken() {
        return mezgebuyetewesenebetken;
    }

    public void setMezgebuyetewesenebetken(String mezgebuyetewesenebetken) {
        this.mezgebuyetewesenebetken = mezgebuyetewesenebetken;
    }

    public String getKetero() {
        return ketero;
    }

    public void setKetero(String ketero) {
        this.ketero = ketero;
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
        if (!(object instanceof Qettegnakisandkesemelsmezgeb)) {
            return false;
        }
        Qettegnakisandkesemelsmezgeb other = (Qettegnakisandkesemelsmezgeb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.databse.Qettegnakisandkesemelsmezgeb[ id=" + id + " ]";
    }
    
}
