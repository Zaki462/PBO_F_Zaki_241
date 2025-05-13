package com.praktikum.main;

import com.praktikum.users.*;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("Sugeng Tumblr", "202410370110241", "admin241", "password241");
        Mahasiswa mahasiswa = new Mahasiswa("Ahmad Fakhruddin Zaki", "202410370110241");

        System.out.println("=== Sistem Login ===");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.print("Pilih menu (1/2): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        if (pilihan == 1) {
            System.out.print("Masukkan Username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan Password: ");
            String password = scanner.nextLine();

            if (admin.login(username, password)) {
                admin.displayInfo();
                admin.displayAppMenu(scanner); //Memanggil menu aplikasi untuk objek admin
            } else {
                System.out.println("Login Admin gagal! Username atau password salah.");
            }

        } else if (pilihan == 2) {
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();

            if (mahasiswa.login(nama, nim)) {
                mahasiswa.displayInfo();
                mahasiswa.displayAppMenu(scanner); //Memanggil menu aplikasi untuk objek mahasiswa
            } else {
                System.out.println("Login Mahasiswa gagal! Nama atau NIM salah.");
            }

        } else {
            System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}