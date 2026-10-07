package com.netaji.CrudOperation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//model class 
@Entity
@Table(name = "UserRegs_tb")
public class UserRegs {
    @Id
    long id;
    String name;
    long mobileNo;
    String email;
    String password;
    String  createdDate;
    String  modifiedDate;
    String  deleteDate;
    boolean status;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public String getDeleteDate() {
        return deleteDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setDeleteDate(String deleteDate) {
        this.deleteDate = deleteDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserRegs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobileNo=" + mobileNo +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                ", deleteDate='" + deleteDate + '\'' +
                ", status=" + status +
                '}';
    }
}

/*
ID = long
  Name = string
  Mobile No. = long
  Email = string
  Password = string
  Created date = string
  Modified date = string
  Delete date = string
  Status : active /not = Boolean

 */