package com.praktikum.models;

public class Item {
    // Atribut
    private String nama;
    private String deskripsi;
    private String lokasi;
    private String status;

    // Konstruktor
    public Item(String nama, String deskripsi, String lokasi, String status) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.status = status;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    public String getLokasi() {
        return lokasi;
    }
    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}