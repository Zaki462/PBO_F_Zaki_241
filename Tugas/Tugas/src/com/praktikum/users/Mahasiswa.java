package com.praktikum.users;

import com.praktikum.actions.MahasiswaAction;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaAction {

    public Mahasiswa(String nama, String nim) {
        super(nama, nim); // Memanggil constructor dari User
    }

    @Override
    public boolean login(String inputNama, String inputNim) {
        return getNama().equals(inputNama) && getNim().equals(inputNim);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Mahasiswa berhasil!");
        System.out.println("Nama: " + getNama() + ", NIM: " + getNim());
    }

    @Override
    public void displayAppMenu(Scanner scanner){ //Menyediakan menu untuk mahasiswa agar bisa melaporkan barang atau melihat laporan
        while (true) {
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("sampean pilih kang: ");

            while (!scanner.hasNextInt()) {
                System.out.println("sampean pilih angka diatas");
                scanner.next();
            }

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Buang newline

            switch (pilihan){
                case 1:
                    reportItems(scanner);
                    break;
                case 2:
                    viewReportedItems();
                    break;
                case 0:
                    System.out.println("Anda berhasil logout");
                    System.exit(0); // Keluar dari program
                default:
                    System.out.println("pilihan harus benar kang.");
            }
        }
    }


    @Override
    public void reportItems(Scanner scanner){
        System.out.print("Masukkan Nama Barang: "); //Mahasiswa mengisi laporan barang hilang/temuan
        String namaBarang = scanner.nextLine();

        System.out.print("Masukkan Deskripsi Barang: ");
        String deskripsiBarang = scanner.nextLine();

        System.out.print("Masukkan Lokasi Terakhir Barang: ");
        String lokasiBarang = scanner.nextLine();

        System.out.println("Laporan diterima");
        System.out.println("Barang: " + namaBarang);
        System.out.println("Deskripsi: " + deskripsiBarang);
        System.out.println("Lokasi: " + lokasiBarang);
    }

    @Override
    public void viewReportedItems(){
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
    }
}
