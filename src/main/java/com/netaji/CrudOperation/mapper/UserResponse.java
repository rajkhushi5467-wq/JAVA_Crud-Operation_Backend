package com.netaji.CrudOperation.mapper;

public class UserResponse {
 long id;
 String name;
 long mobileNo;
 String email;
 String password;

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

    @Override
    public String toString() {
        return "UserResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobileNo=" + mobileNo +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
/*
 Id = long
  Name = string
  Mobile No. = long
  Email = string
  Password = string

 */