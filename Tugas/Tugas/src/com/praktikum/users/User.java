package com.praktikum.users;

public abstract class User {
    private String nama;
    private String nim;

    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public boolean login(String input1, String input2) {
        // Ini method yang akan dioverride
        return false;
    }

    public void displayInfo() {
        System.out.println("User: " + nama + ", NIM: " + nim);
    }
    abstract void displayAppMenu(java.util.Scanner scanner); //method abstrak yang dideklarasikan di dalam kelas abstrak atau interface
}
