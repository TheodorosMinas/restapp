package com.dodoscompany.somedatademo.models;

import jakarta.validation.constraints.*;

import java.util.List;

public class Customer {
    @NotNull(message = "is required")
    @NotEmpty(message = "First name is required")
    @Size(min = 5, message = "is required")
    private String fname;
    @NotNull(message = "is required")
    private String lname;
    @NotNull(message = "is required")
    private String country;
    @NotNull(message = "is required")
    private String plang;
    @NotNull(message = "is required")
    private List<String> operatingSystems;
    @Min(value = 1, message = "must be greater than or equal to 1")
    @Max(value = 110, message = "must be less than or equal to 110")
    private int age;
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "must be a valid email address")
    private String email;




    public Customer() {
    }

    public Customer(String fname, String lname,String country,String plang, List<String> operatingSystems,int age) {

        this.fname = fname;
        this.lname = lname;
        this.plang=plang;
        this.country=country;
        this.operatingSystems = operatingSystems;
        this.age=age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(List<String> operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    public String getPlang() {
        return plang;
    }
    public void setPlang(String plang) {
        this.plang = plang;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", country='" + country + '\'' +
                ", plang='" + plang + '\'' +
                ", operating Systems='" + operatingSystems + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
