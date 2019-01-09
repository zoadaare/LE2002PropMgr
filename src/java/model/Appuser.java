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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "APPUSER", schema = "LEDEV")
@NamedQueries({
      @NamedQuery(name = "Appuser.findAll", query = "SELECT a FROM Appuser a")
    , @NamedQuery(name = "Appuser.findByEmail", query = "SELECT a FROM Appuser a WHERE a.email = :email")
    , @NamedQuery(name = "Appuser.findByUname", query = "SELECT a FROM Appuser a WHERE a.uname = :uname")
    , @NamedQuery(name = "Appuser.findByComkey", query = "SELECT a FROM Appuser a WHERE a.comkey = :comkey")
    , @NamedQuery(name = "Appuser.findById", query = "SELECT a FROM Appuser a WHERE a.id = :id")
    , @NamedQuery(name = "Appuser.findByIdType", query = "SELECT a FROM Appuser a WHERE a.idType = :idType")
    , @NamedQuery(name = "Appuser.findByAccountStatus", query = "SELECT a FROM Appuser a WHERE a.accountStatus = :accountStatus")
    , @NamedQuery(name = "Appuser.findByUserType", query = "SELECT a FROM Appuser a WHERE a.userType = :userType")
    , @NamedQuery(name = "Appuser.findByFullName", query = "SELECT a FROM Appuser a WHERE a.fullName = :fullName")})
public class Appuser implements Serializable {

    private static final long serialVersionUID = 1L;
    private String email;
    private String uname;
    private String comkey;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private String id;
    @Column(name = "ID_TYPE")
    private String idType;
    @Column(name = "ACCOUNT_STATUS")
    private String accountStatus;
    @Column(name = "USER_TYPE")
    private String userType;
    @Column(name = "FULL_NAME")
    private String fullName;
    @JoinColumn(name = "ORG_REG_ID", referencedColumnName = "REGISTRATION_ID")
    @ManyToOne
    private Organization orgRegId;

    public Appuser() {
    }

    public Appuser(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getComkey() {
        return comkey;
    }

    public void setComkey(String comkey) {
        this.comkey = comkey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Organization getOrgRegId() {
        return orgRegId;
    }

    public void setOrgRegId(Organization orgRegId) {
        this.orgRegId = orgRegId;
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
        if (!(object instanceof Appuser)) {
            return false;
        }
        Appuser other = (Appuser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Appuser[ id=" + id + " ]";
    }
    
}
