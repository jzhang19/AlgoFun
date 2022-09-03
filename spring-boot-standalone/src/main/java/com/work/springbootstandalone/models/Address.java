package com.work.springbootstandalone.models;

public class Address {
    
    private String address;
    private String postalCode;
    private String city;
    private String zone;
    private String country;
    
    public Address(String address, String postalCode, String city, String zone, String country) {
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.zone = zone;
        this.country = country;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getZone() {
        return zone;
    }
    public void setZone(String zone) {
        this.zone = zone;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    
}
