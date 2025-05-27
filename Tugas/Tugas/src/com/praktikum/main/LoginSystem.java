package com.praktikum.main;

import java.util.Scanner;

import com.praktikum.users.ConsoleColor;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.Admin;
import com.praktikum.users.User;

public class LoginSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_ATTEMPTS = 3;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Sistem Login ===");
            System.out.println("1. Login sebagai Mahasiswa");
            System.out.println("2. Login sebagai Admin");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi (1-3): ");

            String pilihan = scanner.nextLine().trim();

            switch (pilihan) {
                case "1":
                    if (attemptLogin("Mahasiswa")) return;
                    break;
                case "2":
                    if (attemptLogin("Admin")) return;
                    break;
                case "3":
                    System.out.println(ConsoleColor.green("Terima kasih telah menggunakan sistem."));
                    scanner.close();
                    return;
                default:
                    System.out.println(ConsoleColor.red("Pilihan tidak valid. Silakan coba lagi."));
            }
        }
    }

    private static boolean attemptLogin(String role) {
        int attempts = 0;

        while (attempts < MAX_ATTEMPTS) {
            User user = role.equals("Mahasiswa") ? loginMahasiswa() : loginAdmin();
            if (user != null) {
                System.out.println(ConsoleColor.green("\nLogin berhasil sebagai " + role + "."));
                user.displayInfo(); // menampilkan info akun
                user.displayAppMenu(scanner); // polymorphic call
                return true;
            }

            attempts++;
            int sisa = MAX_ATTEMPTS - attempts;
            if (sisa > 0) {
                System.out.println(ConsoleColor.red("Kesempatan tersisa: " + sisa));
            } else {
                System.out.println(ConsoleColor.red("\nAnda telah gagal login 3 kali. Sistem keluar."));
                System.exit(0);
            }
        }
        return false;
    }

    private static User loginMahasiswa() {
        System.out.print("\nMasukkan Nama: ");
        String nama = scanner.nextLine().trim();
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine().trim();

        if (nama.isEmpty() || nim.isEmpty()) {
            System.out.println(ConsoleColor.red("Nama dan NIM tidak boleh kosong!"));
            return null;
        }

        Mahasiswa mahasiswa = new Mahasiswa(nama, nim);
        return mahasiswa.login(nama, nim) ? mahasiswa : null;
    }

    private static User loginAdmin() {
        System.out.print("\nMasukkan Username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine().trim();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println(ConsoleColor.red("Username dan Password tidak boleh kosong!"));
            return null;
        }

        Admin admin = new Admin(username, password);
        return admin.login(username, password) ? admin : null;
    }
}