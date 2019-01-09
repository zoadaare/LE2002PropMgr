/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "ADDRESS", schema = "LEDEV")
@NamedQueries({
      @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findByAddressId", query = "SELECT a FROM Address a WHERE a.addressId = :addressId")
    , @NamedQuery(name = "Address.findByStreet", query = "SELECT a FROM Address a WHERE a.street = :street")
    , @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city")
    , @NamedQuery(name = "Address.findByStateGeodiv", query = "SELECT a FROM Address a WHERE a.stateGeodiv = :stateGeodiv")
    , @NamedQuery(name = "Address.findByZipcode", query = "SELECT a FROM Address a WHERE a.zipcode = :zipcode")
    , @NamedQuery(name = "Address.findByCountry", query = "SELECT a FROM Address a WHERE a.country = :country")
    , @NamedQuery(name = "Address.findBySpatialObjId", query = "SELECT a FROM Address a WHERE a.spatialObjId = :spatialObjId")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADDRESS_ID")
    private BigDecimal addressId;
    private String street;
    private String aptnum;
    private String city;
    @Column(name = "STATE_GEODIV")
    private String stateGeodiv;
    private String zipcode;
    private String country;
    @Column(name = "SPATIAL_OBJ_ID")
    private BigInteger spatialObjId;
    @OneToMany(mappedBy = "addressId")
    private List<Organization> organizationList;

    public Address() {
    }

    public Address(BigDecimal addressId) {
        this.addressId = addressId;
    }

    public BigDecimal getAddressId() {
        return addressId;
    }

    public void setAddressId(BigDecimal addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAptnum() {
        return aptnum;
    }

    public void setAptnum(String aptnum) {
        this.aptnum = aptnum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateGeodiv() {
        return stateGeodiv;
    }

    public void setStateGeodiv(String stateGeodiv) {
        this.stateGeodiv = stateGeodiv;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigInteger getSpatialObjId() {
        return spatialObjId;
    }

    public void setSpatialObjId(BigInteger spatialObjId) {
        this.spatialObjId = spatialObjId;
    }

    public List<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<Organization> organizationList) {
        this.organizationList = organizationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressId != null ? addressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressId == null && other.addressId != null) || (this.addressId != null && !this.addressId.equals(other.addressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Address[ addressId=" + addressId + " ]";
    }
    
}
