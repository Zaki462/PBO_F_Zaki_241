package com.praktikum.users;
import com.praktikum.actions.AdminActions;

import java.util.Scanner;

public class Admin extends User implements AdminActions {
    private String username;
    private String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim); // Memanggil constructor dari User
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Admin berhasil!");
        System.out.println("Nama: " + getNama() + ", NIM: " + getNim());
    }

    @Override
    public void displayAppMenu(Scanner scanner){ // mengelola laporan dan data mahasiswa
        while (true){
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("sampean pilih kang: ");

            while (!scanner.hasNextInt()){
                System.out.println("sampean pilih angka diatas");
                scanner.nextLine();
            }

            int pilihan = scanner.nextInt();
            switch (pilihan){
                case 1:
                    manageItems();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 0:
                    System.out.println("Anda berhasil logout");
                    System.exit(0);
                default:
                    System.out.println("pilihan harus benar kang.");
            }
        }
    }
    @Override
    public void manageItems(){
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
    }

    @Override
    public void manageUsers(){
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }
}