package com.praktikum.users;

public abstract class User {
    protected String nama;
    protected String nim;
    protected String password;

    // Konstruktor protected hanya untuk subclass
    protected User(String nama) {
        this.nama = nama;
    }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public void displayInfo() {
        System.out.println("Nama: " + nama);
        if (nim != null) {
            System.out.println("NIM: " + nim);
        }
    }

    public abstract boolean login(String inputNama, String inputCredential);

    public abstract void displayAppMenu(java.util.Scanner scanner);
}