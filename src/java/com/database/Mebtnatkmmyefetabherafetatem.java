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
@Table(name = "mebtnatkmmyefetabherafetatem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findAll", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findById", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.id = :id"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByKebele", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.kebele = :kebele"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByMezgebkutr", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.mezgebkutr = :mezgebkutr"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByYefthbiromeleyakutr", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.yefthbiromeleyakutr = :yefthbiromeleyakutr"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByYexonefthmemriyameleyakutr", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.yexonefthmemriyameleyakutr = :yexonefthmemriyameleyakutr"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByYeworedafthmeleyakutr", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.yeworedafthmeleyakutr = :yeworedafthmeleyakutr"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByMezgebuyetekefetebetken", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.mezgebuyetekefetebetken = :mezgebuyetekefetebetken"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByYefrdbetusim", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.yefrdbetusim = :yefrdbetusim"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByYefrdbetmeleyakutr", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.yefrdbetmeleyakutr = :yefrdbetmeleyakutr"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByYefayluaynet", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.yefayluaynet = :yefayluaynet"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByKsashaynet", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.ksashaynet = :ksashaynet"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByKesashdrgtname", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.kesashdrgtname = :kesashdrgtname"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByKesashname", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.kesashname = :kesashname"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByKesashfname", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.kesashfname = :kesashfname"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByKesashlastname", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.kesashlastname = :kesashlastname"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByYetekesashaynet", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.yetekesashaynet = :yetekesashaynet"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByTekesashdrgtname", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.tekesashdrgtname = :tekesashdrgtname"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByTekesashname", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.tekesashname = :tekesashname"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByTekesashfname", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.tekesashfname = :tekesashfname"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByTekesashlastname", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.tekesashlastname = :tekesashlastname"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByYegenzebumeten", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.yegenzebumeten = :yegenzebumeten"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByFayluyetekemetebetbota", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.fayluyetekemetebetbota = :fayluyetekemetebetbota"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByGetbzat", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.getbzat = :getbzat"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByMezgebuyetewesenebetken", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.mezgebuyetewesenebetken = :mezgebuyetewesenebetken"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByGudayuyalekebethuneta", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.gudayuyalekebethuneta = :gudayuyalekebethuneta"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByKetero", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.ketero = :ketero"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByRegby", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.regby = :regby"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByUpdatedby", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "Mebtnatkmmyefetabherafetatem.findByBalemuya", query = "SELECT m FROM Mebtnatkmmyefetabherafetatem m WHERE m.balemuya = :balemuya")})
public class Mebtnatkmmyefetabherafetatem implements Serializable {

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
    @Column(name = "yefthbiromeleyakutr")
    private String yefthbiromeleyakutr;
    @Size(max = 200)
    @Column(name = "yexonefthmemriyameleyakutr")
    private String yexonefthmemriyameleyakutr;
    @Size(max = 200)
    @Column(name = "yeworedafthmeleyakutr")
    private String yeworedafthmeleyakutr;
    @Size(max = 200)
    @Column(name = "mezgebuyetekefetebetken")
    private String mezgebuyetekefetebetken;
    @Size(max = 200)
    @Column(name = "yefrdbetusim")
    private String yefrdbetusim;
    @Size(max = 200)
    @Column(name = "yefrdbetmeleyakutr")
    private String yefrdbetmeleyakutr;
    @Size(max = 200)
    @Column(name = "yefayluaynet")
    private String yefayluaynet;
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
    @Column(name = "yegenzebumeten")
    private String yegenzebumeten;
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
    @Column(name = "gudayuyalekebethuneta")
    private String gudayuyalekebethuneta;
    @Size(max = 200)
    @Column(name = "ketero")
    private String ketero;
    @Size(max = 200)
    @Column(name = "regby")
    private String regby;
    @Size(max = 200)
    @Column(name = "updatedby")
    private String updatedby;
    @Size(max = 3000)
    @Column(name = "balemuya")
    private String balemuya;
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

    public Mebtnatkmmyefetabherafetatem() {
    }

    public Mebtnatkmmyefetabherafetatem(Integer id) {
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

    public String getYefthbiromeleyakutr() {
        return yefthbiromeleyakutr;
    }

    public void setYefthbiromeleyakutr(String yefthbiromeleyakutr) {
        this.yefthbiromeleyakutr = yefthbiromeleyakutr;
    }

    public String getYexonefthmemriyameleyakutr() {
        return yexonefthmemriyameleyakutr;
    }

    public void setYexonefthmemriyameleyakutr(String yexonefthmemriyameleyakutr) {
        this.yexonefthmemriyameleyakutr = yexonefthmemriyameleyakutr;
    }

    public String getYeworedafthmeleyakutr() {
        return yeworedafthmeleyakutr;
    }

    public void setYeworedafthmeleyakutr(String yeworedafthmeleyakutr) {
        this.yeworedafthmeleyakutr = yeworedafthmeleyakutr;
    }

    public String getMezgebuyetekefetebetken() {
        return mezgebuyetekefetebetken;
    }

    public void setMezgebuyetekefetebetken(String mezgebuyetekefetebetken) {
        this.mezgebuyetekefetebetken = mezgebuyetekefetebetken;
    }

    public String getYefrdbetusim() {
        return yefrdbetusim;
    }

    public void setYefrdbetusim(String yefrdbetusim) {
        this.yefrdbetusim = yefrdbetusim;
    }

    public String getYefrdbetmeleyakutr() {
        return yefrdbetmeleyakutr;
    }

    public void setYefrdbetmeleyakutr(String yefrdbetmeleyakutr) {
        this.yefrdbetmeleyakutr = yefrdbetmeleyakutr;
    }

    public String getYefayluaynet() {
        return yefayluaynet;
    }

    public void setYefayluaynet(String yefayluaynet) {
        this.yefayluaynet = yefayluaynet;
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

    public String getYegenzebumeten() {
        return yegenzebumeten;
    }

    public void setYegenzebumeten(String yegenzebumeten) {
        this.yegenzebumeten = yegenzebumeten;
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

    public String getGudayuyalekebethuneta() {
        return gudayuyalekebethuneta;
    }

    public void setGudayuyalekebethuneta(String gudayuyalekebethuneta) {
        this.gudayuyalekebethuneta = gudayuyalekebethuneta;
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

    public String getBalemuya() {
        return balemuya;
    }

    public void setBalemuya(String balemuya) {
        this.balemuya = balemuya;
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
        if (!(object instanceof Mebtnatkmmyefetabherafetatem)) {
            return false;
        }
        Mebtnatkmmyefetabherafetatem other = (Mebtnatkmmyefetabherafetatem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.databse.Mebtnatkmmyefetabherafetatem[ id=" + id + " ]";
    }
    
}
