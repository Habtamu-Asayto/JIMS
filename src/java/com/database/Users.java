/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
    @NamedQuery(name = "Users.findByFirtstname", query = "SELECT u FROM Users u WHERE u.firtstname = :firtstname"),
    @NamedQuery(name = "Users.findByMiddlename", query = "SELECT u FROM Users u WHERE u.middlename = :middlename"),
    @NamedQuery(name = "Users.findByLastname", query = "SELECT u FROM Users u WHERE u.lastname = :lastname"),
 
   
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
 
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByStatus", query = "SELECT u FROM Users u WHERE u.status = :status")})
public class Users implements Serializable {

    @Lob
    @Column(name = "role")
    private List<Roles>  role;
    @OneToMany(mappedBy = "agelglotsechbalemuya")
    private Collection<Senedochenatebekoch> senedochenatebekochCollection;
    @OneToMany(mappedBy = "misikir")
    private Collection<Wuklna> wuklnaCollection;
    @OneToMany(mappedBy = "tewokay")
    private Collection<Wuklna> wuklnaCollection1;
    @OneToMany(mappedBy = "wekay")
    private Collection<Wuklna> wuklnaCollection2;
   
    @Size(max = 50)
    @Column(name = "phone_number")
    private String phoneNumber;
    
      @Size(max = 1000)
    @Column(name = "caseid")
    private String caseid;

    public String getCaseid() {
        return caseid;
    }

    public void setCaseid(String caseid) {
        this.caseid = caseid;
    }
      
    public String getOrganizationname() {
        return organizationname;
    }

    public void setOrganizationname(String organizationname) {
        this.organizationname = organizationname;
    }
    
    
     
    @Size(max = 1000)
    @Column(name = "organizationname")
    private String organizationname;
    
    
    @Size(max = 50)
    @Column(name = "house_phone_number")
    private String housePhoneNumber;
    @Size(max = 200)
    @Column(name = "kebele")
    private String kebele;
    @Size(max = 200)
    @Column(name = "id_number")
    private String idNumber;
    @Size(max = 200)
    @Column(name = "house_number")
    private String houseNumber;
    @Size(max = 200)
    @Column(name = "pobox")
    private String pobox;
    @Size(max = 200)
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    
    @Size(max = 200)
    @Column(name = "sex")
    private String sex;
      @JoinColumn(name = "title", referencedColumnName = "id")
    @ManyToOne
    private Titlerank title;

    public Titlerank getTitle() {
        return title;
    }

    public void setTitle(Titlerank title) {
        this.title = title;
    }
    
    @JoinColumn(name = "nationality", referencedColumnName = "id")
    @ManyToOne
    private Nationalities nationality;
    @JoinColumn(name = "organization_type", referencedColumnName = "id")
    @ManyToOne
    private Officetypes organizationType;
    @JoinColumn(name = "region", referencedColumnName = "id")
    @ManyToOne
    private Regions region;
    @JoinColumn(name = "woreda", referencedColumnName = "id")
    @ManyToOne
    private Weredas woreda;
    @JoinColumn(name = "zone", referencedColumnName = "id")
    @ManyToOne
    private Zones zone;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "firtstname")
    private String firtstname;
    @Size(max = 200)
    @Column(name = "middlename")
    private String middlename;
    @Size(max = 2000)
    @Column(name = "lastname")
    private String lastname;
    @Size(max = 2000)
  
    @Column(name = "password")
    private String password;
    @Size(max = 2000)
  

    @Column(name = "email")
    private String email;
    @Size(max = 20)
    @Column(name = "status")
    private String status;
    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirtstname() {
        return firtstname;
    }

    public void setFirtstname(String firtstname) {
        this.firtstname = firtstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

   


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
    String pwdd = JavaUtilsEncryption.generateSaltedHash(password.trim(), password.trim());
        this.password = pwdd;
    }

  
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return firtstname +" "+ middlename +" "+lastname;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHousePhoneNumber() {
        return housePhoneNumber;
    }

    public void setHousePhoneNumber(String housePhoneNumber) {
        this.housePhoneNumber = housePhoneNumber;
    }

    public String getKebele() {
        return kebele;
    }

    public void setKebele(String kebele) {
        this.kebele = kebele;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPobox() {
        return pobox;
    }

    public void setPobox(String pobox) {
        this.pobox = pobox;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

 

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Nationalities getNationality() {
        return nationality;
    }

    public void setNationality(Nationalities nationality) {
        this.nationality = nationality;
    }

    public Officetypes getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(Officetypes organizationType) {
        this.organizationType = organizationType;
    }

    public Regions getRegion() {
        return region;
    }

    public void setRegion(Regions region) {
        this.region = region;
    }

    public Weredas getWoreda() {
        return woreda;
    }

    public void setWoreda(Weredas woreda) {
        this.woreda = woreda;
    }

    public Zones getZone() {
        return zone;
    }

    public void setZone(Zones zone) {
        this.zone = zone;
    }


 

    @XmlTransient
    public Collection<Wuklna> getWuklnaCollection() {
        return wuklnaCollection;
    }

    public void setWuklnaCollection(Collection<Wuklna> wuklnaCollection) {
        this.wuklnaCollection = wuklnaCollection;
    }

    @XmlTransient
    public Collection<Wuklna> getWuklnaCollection1() {
        return wuklnaCollection1;
    }

    public void setWuklnaCollection1(Collection<Wuklna> wuklnaCollection1) {
        this.wuklnaCollection1 = wuklnaCollection1;
    }

    @XmlTransient
    public Collection<Wuklna> getWuklnaCollection2() {
        return wuklnaCollection2;
    }

    public void setWuklnaCollection2(Collection<Wuklna> wuklnaCollection2) {
        this.wuklnaCollection2 = wuklnaCollection2;
    }

    public List<Roles> getRole() {
        return role;
    }

    public void setRole(List<Roles> role) {
        this.role = role;
    }

  

    @XmlTransient
    public Collection<Senedochenatebekoch> getSenedochenatebekochCollection() {
        return senedochenatebekochCollection;
    }

    public void setSenedochenatebekochCollection(Collection<Senedochenatebekoch> senedochenatebekochCollection) {
        this.senedochenatebekochCollection = senedochenatebekochCollection;
    }

 
    
}
