/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author warin
 */
@Entity
@Table(name = "DVD_CATALOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DvdCatalog.findAll", query = "SELECT d FROM DvdCatalog d"),
    @NamedQuery(name = "DvdCatalog.findById", query = "SELECT d FROM DvdCatalog d WHERE d.id = :id"),
    @NamedQuery(name = "DvdCatalog.findByDvdNames", query = "SELECT d FROM DvdCatalog d WHERE d.dvdNames = :dvdNames"),
    @NamedQuery(name = "DvdCatalog.findByRate", query = "SELECT d FROM DvdCatalog d WHERE d.rate = :rate"),
    @NamedQuery(name = "DvdCatalog.findByYear", query = "SELECT d FROM DvdCatalog d WHERE d.year = :year"),
    @NamedQuery(name = "DvdCatalog.findByPrice", query = "SELECT d FROM DvdCatalog d WHERE d.price = :price"),
    @NamedQuery(name = "DvdCatalog.findByQuantity", query = "SELECT d FROM DvdCatalog d WHERE d.quantity = :quantity")})
public class DvdCatalog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "DVD_NAMES")
    private String dvdNames;
    @Size(max = 50)
    @Column(name = "RATE")
    private String rate;
    @Size(max = 50)
    @Column(name = "YEAR_")
    private String year;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "QUANTITY")
    private Integer quantity;

    public DvdCatalog() {
    }

    public DvdCatalog(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDvdNames() {
        return dvdNames;
    }

    public void setDvdNames(String dvdNames) {
        this.dvdNames = dvdNames;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
        if (!(object instanceof DvdCatalog)) {
            return false;
        }
        DvdCatalog other = (DvdCatalog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.DvdCatalog[ id=" + id + " ]";
    }
    
}
