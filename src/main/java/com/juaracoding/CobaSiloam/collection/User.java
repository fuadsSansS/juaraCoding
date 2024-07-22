package com.juaracoding.CobaSiloam.collection;

/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author pollc a.k.a. Paul Christian
Java Developer
Created on Tue 19:14
@Last Modified Tue 19:14
Version 1.0
*/
public class User {

    private String nama;
    private String alamat;
    private String email;
    private String noHp;

    public User() {
    }

    public User(String nama, String alamat, String email, String noHp) {
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.noHp = noHp;
    }

    //CTRL + ALT + D
    // SETTER GETTER / BEAN / POJO / MODEL / DOMAIN
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
}