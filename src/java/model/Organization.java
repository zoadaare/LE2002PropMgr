/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "ORGANIZATION", catalog = "", schema = "LEDEV")
@NamedQueries({
    @NamedQuery(name = "Organization.findAll", query = "SELECT o FROM Organization o")
    , @NamedQuery(name = "Organization.findByRegistrationId", query = "SELECT o FROM Organization o WHERE o.registrationId = :registrationId")
    , @NamedQuery(name = "Organization.findByName", query = "SELECT o FROM Organization o WHERE o.name = :name")
    , @NamedQuery(name = "Organization.findByStatus", query = "SELECT o FROM Organization o WHERE o.status = :status")
    , @NamedQuery(name = "Organization.findByPrmContactName", query = "SELECT o FROM Organization o WHERE o.prmContactName = :prmContactName")
    , @NamedQuery(name = "Organization.findByPrmContactPhone", query = "SELECT o FROM Organization o WHERE o.prmContactPhone = :prmContactPhone")
    , @NamedQuery(name = "Organization.findByPrmContactPhoneType", query = "SELECT o FROM Organization o WHERE o.prmContactPhoneType = :prmContactPhoneType")
    , @NamedQuery(name = "Organization.findByEmail", query = "SELECT o FROM Organization o WHERE o.email = :email")})
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "REGISTRATION_ID")
    private String registrationId;
    @Size(max = 200)
    @Column(name = "NAME")
    private String name;
    @Size(max = 20)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 50)
    @Column(name = "PRM_CONTACT_NAME")
    private String prmContactName;
    @Size(max = 50)
    @Column(name = "PRM_CONTACT_PHONE")
    private String prmContactPhone;
    @Size(max = 50)
    @Column(name = "PRM_CONTACT_PHONE_TYPE")
    private String prmContactPhoneType;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "EMAIL")
    private String email;
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    @ManyToOne
    private Address addressId;
    @OneToMany(mappedBy = "orgRegId")
    private List<Appuser> appuserList;

    public Organization() {
    }

    public Organization(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrmContactName() {
        return prmContactName;
    }

    public void setPrmContactName(String prmContactName) {
        this.prmContactName = prmContactName;
    }

    public String getPrmContactPhone() {
        return prmContactPhone;
    }

    public void setPrmContactPhone(String prmContactPhone) {
        this.prmContactPhone = prmContactPhone;
    }

    public String getPrmContactPhoneType() {
        return prmContactPhoneType;
    }

    public void setPrmContactPhoneType(String prmContactPhoneType) {
        this.prmContactPhoneType = prmContactPhoneType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public List<Appuser> getAppuserList() {
        return appuserList;
    }

    public void setAppuserList(List<Appuser> appuserList) {
        this.appuserList = appuserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (registrationId != null ? registrationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organization)) {
            return false;
        }
        Organization other = (Organization) object;
        if ((this.registrationId == null && other.registrationId != null) || (this.registrationId != null && !this.registrationId.equals(other.registrationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Organization[ registrationId=" + registrationId + " ]";
    }
    
}
