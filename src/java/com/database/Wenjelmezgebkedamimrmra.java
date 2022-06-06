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
@Table(name = "wenjelmezgebkedamimrmra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findAll", query = "SELECT w FROM Wenjelmezgebkedamimrmra w"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findById", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.id = :id"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByRegion", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.region = :region"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByZone", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.zone = :zone"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByWoreda", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.woreda = :woreda"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByKebele", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.kebele = :kebele"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByMezgebkutr", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.mezgebkutr = :mezgebkutr"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByFrdbetkrnchafsim", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.frdbetkrnchafsim = :frdbetkrnchafsim"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByFrdbetkrnchafmezgebkutr", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.frdbetkrnchafmezgebkutr = :frdbetkrnchafmezgebkutr"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByYzonesim", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.yzonesim = :yzonesim"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByYzonemezgebkutr", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.yzonemezgebkutr = :yzonemezgebkutr"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByZonekeftegnawfrdbet", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.zonekeftegnawfrdbet = :zonekeftegnawfrdbet"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByZonekeftegnawfrdbetmezgebkutr", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.zonekeftegnawfrdbetmezgebkutr = :zonekeftegnawfrdbetmezgebkutr"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByXqabiheg", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.xqabiheg = :xqabiheg"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByKsashaynet", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.ksashaynet = :ksashaynet"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByKesashdrgtname", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.kesashdrgtname = :kesashdrgtname"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByKesashname", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.kesashname = :kesashname"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByKesashfname", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.kesashfname = :kesashfname"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByKesashlastname", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.kesashlastname = :kesashlastname"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByYetekesashaynet", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.yetekesashaynet = :yetekesashaynet"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByTekesashdrgtname", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.tekesashdrgtname = :tekesashdrgtname"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByTekesashname", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.tekesashname = :tekesashname"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByTekesashfname", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.tekesashfname = :tekesashfname"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByTekesashlastname", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.tekesashlastname = :tekesashlastname"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByWenjeluzrzr", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.wenjeluzrzr = :wenjeluzrzr"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByWenjelukebele", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.wenjelukebele = :wenjelukebele"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByKetero", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.ketero = :ketero"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByFayluyetekemetebetbota", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.fayluyetekemetebetbota = :fayluyetekemetebetbota"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByGetbzat", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.getbzat = :getbzat"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByMezgebuyetekefetebetken", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.mezgebuyetekefetebetken = :mezgebuyetekefetebetken"),
    @NamedQuery(name = "Wenjelmezgebkedamimrmra.findByMezgebuwusanieyagegnebetken", query = "SELECT w FROM Wenjelmezgebkedamimrmra w WHERE w.mezgebuwusanieyagegnebetken = :mezgebuwusanieyagegnebetken")})
public class Wenjelmezgebkedamimrmra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "region")
    private String region;
    @Size(max = 200)
    @Column(name = "zone")
    private String zone;
    @Size(max = 200)
    @Column(name = "woreda")
    private String woreda;
    @Size(max = 200)
    @Column(name = "kebele")
    private String kebele;
    @Size(max = 200)
    @Column(name = "mezgebkutr")
    private String mezgebkutr;
    @Size(max = 200)
    @Column(name = "frdbetkrnchafsim")
    private String frdbetkrnchafsim;
    @Size(max = 200)
    @Column(name = "frdbetkrnchafmezgebkutr")
    private String frdbetkrnchafmezgebkutr;
    @Size(max = 200)
    @Column(name = "yzonesim")
    private String yzonesim;
    @Size(max = 200)
    @Column(name = "yzonemezgebkutr")
    private String yzonemezgebkutr;
    @Size(max = 200)
    @Column(name = "zonekeftegnawfrdbet")
    private String zonekeftegnawfrdbet;
    @Size(max = 200)
    @Column(name = "zonekeftegnawfrdbetmezgebkutr")
    private String zonekeftegnawfrdbetmezgebkutr;
    @Size(max = 200)
    @Column(name = "xqabiheg")
    private String xqabiheg;
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
    @Column(name = "wenjeluzrzr")
    private String wenjeluzrzr;
    @Size(max = 200)
    @Column(name = "wenjelukebele")
    private String wenjelukebele;
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
    @Column(name = "mezgebuwusanieyagegnebetken")
    private String mezgebuwusanieyagegnebetken;
    @JoinColumn(name = "kesashregionid", referencedColumnName = "id")
    @ManyToOne
    private Regions kesashregionid;
    @JoinColumn(name = "tekesashregionid", referencedColumnName = "id")
    @ManyToOne
    private Regions tekesashregionid;
    @JoinColumn(name = "wenjeluregion", referencedColumnName = "id")
    @ManyToOne
    private Regions wenjeluregion;
    @JoinColumn(name = "kesashweredaid", referencedColumnName = "id")
    @ManyToOne
    private Weredas kesashweredaid;
    @JoinColumn(name = "tekesashweredaid", referencedColumnName = "id")
    @ManyToOne
    private Weredas tekesashweredaid;
    @JoinColumn(name = "wenjeluwereda", referencedColumnName = "id")
    @ManyToOne
    private Weredas wenjeluwereda;
    @JoinColumn(name = "kesashzoneid", referencedColumnName = "id")
    @ManyToOne
    private Zones kesashzoneid;
    @JoinColumn(name = "tekesashzoneid", referencedColumnName = "id")
    @ManyToOne
    private Zones tekesashzoneid;
    @JoinColumn(name = "wenjeluzone", referencedColumnName = "id")
    @ManyToOne
    private Zones wenjeluzone;

    public Wenjelmezgebkedamimrmra() {
    }

    public Wenjelmezgebkedamimrmra(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getWoreda() {
        return woreda;
    }

    public void setWoreda(String woreda) {
        this.woreda = woreda;
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

    public String getFrdbetkrnchafsim() {
        return frdbetkrnchafsim;
    }

    public void setFrdbetkrnchafsim(String frdbetkrnchafsim) {
        this.frdbetkrnchafsim = frdbetkrnchafsim;
    }

    public String getFrdbetkrnchafmezgebkutr() {
        return frdbetkrnchafmezgebkutr;
    }

    public void setFrdbetkrnchafmezgebkutr(String frdbetkrnchafmezgebkutr) {
        this.frdbetkrnchafmezgebkutr = frdbetkrnchafmezgebkutr;
    }

    public String getYzonesim() {
        return yzonesim;
    }

    public void setYzonesim(String yzonesim) {
        this.yzonesim = yzonesim;
    }

    public String getYzonemezgebkutr() {
        return yzonemezgebkutr;
    }

    public void setYzonemezgebkutr(String yzonemezgebkutr) {
        this.yzonemezgebkutr = yzonemezgebkutr;
    }

    public String getZonekeftegnawfrdbet() {
        return zonekeftegnawfrdbet;
    }

    public void setZonekeftegnawfrdbet(String zonekeftegnawfrdbet) {
        this.zonekeftegnawfrdbet = zonekeftegnawfrdbet;
    }

    public String getZonekeftegnawfrdbetmezgebkutr() {
        return zonekeftegnawfrdbetmezgebkutr;
    }

    public void setZonekeftegnawfrdbetmezgebkutr(String zonekeftegnawfrdbetmezgebkutr) {
        this.zonekeftegnawfrdbetmezgebkutr = zonekeftegnawfrdbetmezgebkutr;
    }

    public String getXqabiheg() {
        return xqabiheg;
    }

    public void setXqabiheg(String xqabiheg) {
        this.xqabiheg = xqabiheg;
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

    public String getWenjeluzrzr() {
        return wenjeluzrzr;
    }

    public void setWenjeluzrzr(String wenjeluzrzr) {
        this.wenjeluzrzr = wenjeluzrzr;
    }

    public String getWenjelukebele() {
        return wenjelukebele;
    }

    public void setWenjelukebele(String wenjelukebele) {
        this.wenjelukebele = wenjelukebele;
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

    public String getMezgebuwusanieyagegnebetken() {
        return mezgebuwusanieyagegnebetken;
    }

    public void setMezgebuwusanieyagegnebetken(String mezgebuwusanieyagegnebetken) {
        this.mezgebuwusanieyagegnebetken = mezgebuwusanieyagegnebetken;
    }

    public Regions getKesashregionid() {
        return kesashregionid;
    }

    public void setKesashregionid(Regions kesashregionid) {
        this.kesashregionid = kesashregionid;
    }

    public Regions getTekesashregionid() {
        return tekesashregionid;
    }

    public void setTekesashregionid(Regions tekesashregionid) {
        this.tekesashregionid = tekesashregionid;
    }

    public Regions getWenjeluregion() {
        return wenjeluregion;
    }

    public void setWenjeluregion(Regions wenjeluregion) {
        this.wenjeluregion = wenjeluregion;
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

    public Weredas getWenjeluwereda() {
        return wenjeluwereda;
    }

    public void setWenjeluwereda(Weredas wenjeluwereda) {
        this.wenjeluwereda = wenjeluwereda;
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

    public Zones getWenjeluzone() {
        return wenjeluzone;
    }

    public void setWenjeluzone(Zones wenjeluzone) {
        this.wenjeluzone = wenjeluzone;
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
        if (!(object instanceof Wenjelmezgebkedamimrmra)) {
            return false;
        }
        Wenjelmezgebkedamimrmra other = (Wenjelmezgebkedamimrmra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.databse.Wenjelmezgebkedamimrmra[ id=" + id + " ]";
    }
    
}
