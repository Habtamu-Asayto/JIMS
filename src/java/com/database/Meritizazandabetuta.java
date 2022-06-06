/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.ParseException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;

/**
 *
 * @author fedlu
 */
@Entity
@Table(name = "meritizazandabetuta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meritizazandabetuta.findAll", query = "SELECT m FROM Meritizazandabetuta m"),
    @NamedQuery(name = "Meritizazandabetuta.findById", query = "SELECT m FROM Meritizazandabetuta m WHERE m.id = :id"),
    @NamedQuery(name = "Meritizazandabetuta.findByAgelgilotyetesetebetken", query = "SELECT m FROM Meritizazandabetuta m WHERE m.agelgilotyetesetebetken = :agelgilotyetesetebetken"),
    @NamedQuery(name = "Meritizazandabetuta.findByAgelglotteyakiaynet", query = "SELECT m FROM Meritizazandabetuta m WHERE m.agelglotteyakiaynet = :agelglotteyakiaynet"),
    @NamedQuery(name = "Meritizazandabetuta.findByFname", query = "SELECT m FROM Meritizazandabetuta m WHERE m.fname = :fname"),
    @NamedQuery(name = "Meritizazandabetuta.findByGlgalotteyakiaynet", query = "SELECT m FROM Meritizazandabetuta m WHERE m.glgalotteyakiaynet = :glgalotteyakiaynet"),
    @NamedQuery(name = "Meritizazandabetuta.findByGlglaotteyakiname", query = "SELECT m FROM Meritizazandabetuta m WHERE m.glglaotteyakiname = :glglaotteyakiname"),
    @NamedQuery(name = "Meritizazandabetuta.findByGlglaotteyaksechaynet", query = "SELECT m FROM Meritizazandabetuta m WHERE m.glglaotteyaksechaynet = :glglaotteyaksechaynet"),
    @NamedQuery(name = "Meritizazandabetuta.findByGlglaotteyaksechnmae", query = "SELECT m FROM Meritizazandabetuta m WHERE m.glglaotteyaksechnmae = :glglaotteyaksechnmae"),
    @NamedQuery(name = "Meritizazandabetuta.findByHager", query = "SELECT m FROM Meritizazandabetuta m WHERE m.hager = :hager"),
    @NamedQuery(name = "Meritizazandabetuta.findByKebele", query = "SELECT m FROM Meritizazandabetuta m WHERE m.kebele = :kebele"),
    @NamedQuery(name = "Meritizazandabetuta.findByKetero", query = "SELECT m FROM Meritizazandabetuta m WHERE m.ketero = :ketero"),
    @NamedQuery(name = "Meritizazandabetuta.findByLastname", query = "SELECT m FROM Meritizazandabetuta m WHERE m.lastname = :lastname"),
    @NamedQuery(name = "Meritizazandabetuta.findByMezgebuyetekefetebetken", query = "SELECT m FROM Meritizazandabetuta m WHERE m.mezgebuyetekefetebetken = :mezgebuyetekefetebetken"),
    @NamedQuery(name = "Meritizazandabetuta.findByName", query = "SELECT m FROM Meritizazandabetuta m WHERE m.name = :name"),
    @NamedQuery(name = "Meritizazandabetuta.findByWultekebayfname", query = "SELECT m FROM Meritizazandabetuta m WHERE m.wultekebayfname = :wultekebayfname"),
    @NamedQuery(name = "Meritizazandabetuta.findByWultekebaylastname", query = "SELECT m FROM Meritizazandabetuta m WHERE m.wultekebaylastname = :wultekebaylastname"),
    @NamedQuery(name = "Meritizazandabetuta.findByWultekebayname", query = "SELECT m FROM Meritizazandabetuta m WHERE m.wultekebayname = :wultekebayname"),
    @NamedQuery(name = "Meritizazandabetuta.findByYefayluaynet", query = "SELECT m FROM Meritizazandabetuta m WHERE m.yefayluaynet = :yefayluaynet"),
    @NamedQuery(name = "Meritizazandabetuta.findByYefetihbiromeleyakutr", query = "SELECT m FROM Meritizazandabetuta m WHERE m.yefetihbiromeleyakutr = :yefetihbiromeleyakutr"),
    @NamedQuery(name = "Meritizazandabetuta.findByYegenzebmeten", query = "SELECT m FROM Meritizazandabetuta m WHERE m.yegenzebmeten = :yegenzebmeten"),
    @NamedQuery(name = "Meritizazandabetuta.findByYeweredafithmemrya", query = "SELECT m FROM Meritizazandabetuta m WHERE m.yeweredafithmemrya = :yeweredafithmemrya"),
    @NamedQuery(name = "Meritizazandabetuta.findByYezonefithmemroya", query = "SELECT m FROM Meritizazandabetuta m WHERE m.yezonefithmemroya = :yezonefithmemroya"),
    @NamedQuery(name = "Meritizazandabetuta.findByPhonekesash", query = "SELECT m FROM Meritizazandabetuta m WHERE m.phonekesash = :phonekesash"),
    @NamedQuery(name = "Meritizazandabetuta.findByPhonetekesash", query = "SELECT m FROM Meritizazandabetuta m WHERE m.phonetekesash = :phonetekesash"),
    @NamedQuery(name = "Meritizazandabetuta.findByKesashmessegeflag", query = "SELECT m FROM Meritizazandabetuta m WHERE m.kesashmessegeflag = :kesashmessegeflag"),
    @NamedQuery(name = "Meritizazandabetuta.findByTekesashmessegeflag", query = "SELECT m FROM Meritizazandabetuta m WHERE m.tekesashmessegeflag = :tekesashmessegeflag"),
    @NamedQuery(name = "Meritizazandabetuta.findByRegistrationmessageflag", query = "SELECT m FROM Meritizazandabetuta m WHERE m.registrationmessageflag = :registrationmessageflag"),
    @NamedQuery(name = "Meritizazandabetuta.findByTekesashregistration", query = "SELECT m FROM Meritizazandabetuta m WHERE m.tekesashregistration = :tekesashregistration"),
    @NamedQuery(name = "Meritizazandabetuta.findByKeteromknyat", query = "SELECT m FROM Meritizazandabetuta m WHERE m.keteromknyat = :keteromknyat"),
    @NamedQuery(name = "Meritizazandabetuta.findByRegby", query = "SELECT m FROM Meritizazandabetuta m WHERE m.regby = :regby"),
    @NamedQuery(name = "Meritizazandabetuta.findByUpdatedby", query = "SELECT m FROM Meritizazandabetuta m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "Meritizazandabetuta.findBySeason", query = "SELECT m FROM Meritizazandabetuta m WHERE m.season = :season"),
    @NamedQuery(name = "Meritizazandabetuta.findByWulrekikwusanie", query = "SELECT m FROM Meritizazandabetuta m WHERE m.wulrekikwusanie = :wulrekikwusanie"),
    @NamedQuery(name = "Meritizazandabetuta.findByYewulaynet", query = "SELECT m FROM Meritizazandabetuta m WHERE m.yewulaynet = :yewulaynet"),
    @NamedQuery(name = "Meritizazandabetuta.findByBalemuya", query = "SELECT m FROM Meritizazandabetuta m WHERE m.balemuya = :balemuya")})
public class Meritizazandabetuta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "agelgilotyetesetebetken")
    private String agelgilotyetesetebetken;
    @Size(max = 200)
    @Column(name = "agelglotteyakiaynet")
    private String agelglotteyakiaynet;
    @Size(max = 200)
    @Column(name = "fname")
    private String fname;
    @Size(max = 200)
    @Column(name = "glgalotteyakiaynet")
    private String glgalotteyakiaynet;
    @Size(max = 200)
    @Column(name = "glglaotteyakiname")
    private String glglaotteyakiname;
    @Size(max = 200)
    @Column(name = "glglaotteyaksechaynet")
    private String glglaotteyaksechaynet;
    @Size(max = 200)
    @Column(name = "glglaotteyaksechnmae")
    private String glglaotteyaksechnmae;
    @Size(max = 200)
    @Column(name = "hager")
    private String hager;
    @Size(max = 200)
    @Column(name = "kebele")
    private String kebele;
    @Size(max = 200)
    @Column(name = "ketero")
    private String ketero;
    @Size(max = 200)
    @Column(name = "lastname")
    private String lastname;
    @Size(max = 200)
    @Column(name = "mezgebuyetekefetebetken")
    private String mezgebuyetekefetebetken;
    @Size(max = 200)
    @Column(name = "name")
    private String name;
    @Size(max = 200)
    @Column(name = "wultekebayfname")
    private String wultekebayfname;
    @Size(max = 200)
    @Column(name = "wultekebaylastname")
    private String wultekebaylastname;
    @Size(max = 200)
    @Column(name = "wultekebayname")
    private String wultekebayname;
    @Size(max = 200)
    @Column(name = "yefayluaynet")
    private String yefayluaynet;
    @Size(max = 200)
    @Column(name = "yefetihbiromeleyakutr")
    private String yefetihbiromeleyakutr;
    @Size(max = 200)
    @Column(name = "yegenzebmeten")
    private String yegenzebmeten;
    @Size(max = 200)
    @Column(name = "yeweredafithmemrya")
    private String yeweredafithmemrya;
    @Size(max = 200)
    @Column(name = "yezonefithmemroya")
    private String yezonefithmemroya;
    @Size(max = 200)
    @Column(name = "phonekesash")
    private String phonekesash;
    @Size(max = 200)
    @Column(name = "phonetekesash")
    private String phonetekesash;
    @Size(max = 20)
    @Column(name = "kesashmessegeflag")
    private String kesashmessegeflag;
    @Size(max = 20)
    @Column(name = "tekesashmessegeflag")
    private String tekesashmessegeflag;
    @Size(max = 20)
    @Column(name = "registrationmessageflag")
    private String registrationmessageflag;
    @Size(max = 20)
    @Column(name = "tekesashregistration")
    private String tekesashregistration;
    @Size(max = 200)
    @Column(name = "keteromknyat")
    private String keteromknyat;
    @Size(max = 200)
    @Column(name = "regby")
    private String regby;
    @Size(max = 200)
    @Column(name = "updatedby")
    private String updatedby;
    @Size(max = 200)
    @Column(name = "season")
    private String season;
    @Size(max = 200)
    @Column(name = "wulrekikwusanie")
    private String wulrekikwusanie;
    @Size(max = 3000)
    @Column(name = "yewulaynet")
    private String yewulaynet;
    @Size(max = 3000)
    @Column(name = "balemuya")
    private String balemuya;
    @JoinColumn(name = "region", referencedColumnName = "id")
    @ManyToOne
    private Regions region;
    @JoinColumn(name = "regionid", referencedColumnName = "id")
    @ManyToOne
    private Regions regionid;
    @JoinColumn(name = "woreda", referencedColumnName = "id")
    @ManyToOne
    private Weredas woreda;
    @JoinColumn(name = "woredaid", referencedColumnName = "id")
    @ManyToOne
    private Weredas woredaid;
    @JoinColumn(name = "zone", referencedColumnName = "id")
    @ManyToOne
    private Zones zone;
    @JoinColumn(name = "zoneid", referencedColumnName = "id")
    @ManyToOne
    private Zones zoneid;

    public Meritizazandabetuta() {
    }

    public Meritizazandabetuta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgelgilotyetesetebetken() {
        return agelgilotyetesetebetken;
    }

    public void setAgelgilotyetesetebetken(String agelgilotyetesetebetken) {
        this.agelgilotyetesetebetken = agelgilotyetesetebetken;
    }

    public String getAgelglotteyakiaynet() {
        return agelglotteyakiaynet;
    }

    public void setAgelglotteyakiaynet(String agelglotteyakiaynet) {
        this.agelglotteyakiaynet = agelglotteyakiaynet;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getGlgalotteyakiaynet() {
        return glgalotteyakiaynet;
    }

    public void setGlgalotteyakiaynet(String glgalotteyakiaynet) {
        this.glgalotteyakiaynet = glgalotteyakiaynet;
    }

    public String getGlglaotteyakiname() {
        return glglaotteyakiname;
    }

    public void setGlglaotteyakiname(String glglaotteyakiname) {
        this.glglaotteyakiname = glglaotteyakiname;
    }

    public String getGlglaotteyaksechaynet() {
        return glglaotteyaksechaynet;
    }

    public void setGlglaotteyaksechaynet(String glglaotteyaksechaynet) {
        this.glglaotteyaksechaynet = glglaotteyaksechaynet;
    }

    public String getGlglaotteyaksechnmae() {
        return glglaotteyaksechnmae;
    }

    public void setGlglaotteyaksechnmae(String glglaotteyaksechnmae) {
        this.glglaotteyaksechnmae = glglaotteyaksechnmae;
    }

    public String getHager() {
        return hager;
    }

    public void setHager(String hager) {
        this.hager = hager;
    }

    public String getKebele() {
        return kebele;
    }

    public void setKebele(String kebele) {
        this.kebele = kebele;
    }

    public String getKetero() {
        return ketero;
    }

    public void setKetero(String ketero) {
        this.ketero = ketero;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMezgebuyetekefetebetken() {
        return mezgebuyetekefetebetken;
    }

    public void setMezgebuyetekefetebetken(String mezgebuyetekefetebetken) {
        this.mezgebuyetekefetebetken = mezgebuyetekefetebetken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWultekebayfname() {
        return wultekebayfname;
    }

    public void setWultekebayfname(String wultekebayfname) {
        this.wultekebayfname = wultekebayfname;
    }

    public String getWultekebaylastname() {
        return wultekebaylastname;
    }

    public void setWultekebaylastname(String wultekebaylastname) {
        this.wultekebaylastname = wultekebaylastname;
    }

    public String getWultekebayname() {
        return wultekebayname;
    }

    public void setWultekebayname(String wultekebayname) {
        this.wultekebayname = wultekebayname;
    }

    public String getYefayluaynet() {
        return yefayluaynet;
    }

    public void setYefayluaynet(String yefayluaynet) {
        this.yefayluaynet = yefayluaynet;
    }

    public String getYefetihbiromeleyakutr() {
        return yefetihbiromeleyakutr;
    }

    public void setYefetihbiromeleyakutr(String yefetihbiromeleyakutr) {
        this.yefetihbiromeleyakutr = yefetihbiromeleyakutr;
    }

    public String getYegenzebmeten() {
        return yegenzebmeten;
    }

    public void setYegenzebmeten(String yegenzebmeten) {
        this.yegenzebmeten = yegenzebmeten;
    }

    public String getYeweredafithmemrya() {
        return yeweredafithmemrya;
    }

    public void setYeweredafithmemrya(String yeweredafithmemrya) {
        this.yeweredafithmemrya = yeweredafithmemrya;
    }

    public String getYezonefithmemroya() {
        return yezonefithmemroya;
    }

    public void setYezonefithmemroya(String yezonefithmemroya) {
        this.yezonefithmemroya = yezonefithmemroya;
    }

    public String getPhonekesash() {
        return phonekesash;
    }

    public void setPhonekesash(String phonekesash) {
        this.phonekesash = phonekesash;
    }

    public String getPhonetekesash() {
        return phonetekesash;
    }

    public void setPhonetekesash(String phonetekesash) {
        this.phonetekesash = phonetekesash;
    }

    public String getKesashmessegeflag() {
        return kesashmessegeflag;
    }

    public void setKesashmessegeflag(String kesashmessegeflag) {
        this.kesashmessegeflag = kesashmessegeflag;
    }

    public String getTekesashmessegeflag() {
        return tekesashmessegeflag;
    }

    public void setTekesashmessegeflag(String tekesashmessegeflag) {
        this.tekesashmessegeflag = tekesashmessegeflag;
    }

    public String getRegistrationmessageflag() {
        return registrationmessageflag;
    }

    public void setRegistrationmessageflag(String registrationmessageflag) {
        this.registrationmessageflag = registrationmessageflag;
    }

    public String getTekesashregistration() {
        return tekesashregistration;
    }

    public void setTekesashregistration(String tekesashregistration) {
        this.tekesashregistration = tekesashregistration;
    }

    public String getKeteromknyat() {
        return keteromknyat;
    }

    public void setKeteromknyat(String keteromknyat) {
        this.keteromknyat = keteromknyat;
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

    public String getWulrekikwusanie() {
        return wulrekikwusanie;
    }

    public void setWulrekikwusanie(String wulrekikwusanie) {
        this.wulrekikwusanie = wulrekikwusanie;
    }

    public String getYewulaynet() {
        return yewulaynet;
    }

    public void setYewulaynet(String yewulaynet) {
        this.yewulaynet = yewulaynet;
    }

    public String getBalemuya() {
        return balemuya;
    }

    public void setBalemuya(String balemuya) {
        this.balemuya = balemuya;
    }

    public Regions getRegion() {
        return region;
    }

    public void setRegion(Regions region) {
        this.region = region;
    }

    public Regions getRegionid() {
        return regionid;
    }

    public void setRegionid(Regions regionid) {
        this.regionid = regionid;
    }

    public Weredas getWoreda() {
        return woreda;
    }

    public void setWoreda(Weredas woreda) {
        this.woreda = woreda;
    }

    public Weredas getWoredaid() {
        return woredaid;
    }

    public void setWoredaid(Weredas woredaid) {
        this.woredaid = woredaid;
    }

    public Zones getZone() {
        return zone;
    }

    public void setZone(Zones zone) {
        this.zone = zone;
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
        if (!(object instanceof Meritizazandabetuta)) {
            return false;
        }
        Meritizazandabetuta other = (Meritizazandabetuta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.databse.Meritizazandabetuta[ id=" + id + " ]";
    }
     public void handleFileUploadfile(FileUploadEvent event) throws ParseException {
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        UploadedFile file = event.getFile();
       
        try{
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
     String ext1 = FilenameUtils.getExtension(file.getFileName());

     File filee = File.createTempFile("meritiza-"+" ", "."+ext1, new File("D://WoredaFitih//meritizaz"));
      FileOutputStream fos = new FileOutputStream( filee);
            setHager(filee.getAbsolutePath());
            
        InputStream is = file.getInputStream();
        
            int BUFFER_SIZE = 55678;
            byte[] buffer = new byte[BUFFER_SIZE];
            int a;
            while(true){
                a = is.read(buffer);
                if(a < 0) break;
                fos.write(buffer, 0, a);
                fos.flush();
            }
            fos.close();
            is.close();
        }catch(IOException e){
        }
  FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
