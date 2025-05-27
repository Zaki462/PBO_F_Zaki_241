package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.models.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.praktikum.models.ItemManager.reportedItems;
import static com.praktikum.users.ConsoleColor.*;

public class Mahasiswa extends User implements MahasiswaActions {

    // Daftar mahasiswa terdaftar
    public static final List<Mahasiswa> daftarMahasiswa = new ArrayList<>();

    static {
        daftarMahasiswa.add(new Mahasiswa("Ahmad Fakhruddin", "202410370110241"));
        daftarMahasiswa.add(new Mahasiswa("Ahmad Budi", "20241037101123"));
        daftarMahasiswa.add(new Mahasiswa("King Andi", "20241037101099"));
        daftarMahasiswa.add(new Mahasiswa("Queen Caca", "20241037101089"));
        daftarMahasiswa.add(new Mahasiswa("Prince Dede", "20241037101231"));
    }

    private final String nim;

    public Mahasiswa(String nama, String nim) {
        super(nama);
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    @Override
    public boolean login(String inputNama, String inputNim) {
        return daftarMahasiswa.stream()
                .anyMatch(mhs -> mhs.getNama().equalsIgnoreCase(inputNama)
                        && mhs.getNim().equals(inputNim));
    }

    @Override
    public void displayInfo() {
        System.out.println("\n" + cyan("=== Informasi Mahasiswa ==="));
        super.displayInfo();
        System.out.println("NIM   : " + nim);
        System.out.println("Status: " + green("Mahasiswa Terdaftar"));
    }

    @Override
    public void reportItem(Scanner scanner) {
        try {
            System.out.print("Masukkan Nama Barang              : ");
            String namaBarang = scanner.nextLine();

            System.out.print("Masukkan Deskripsi Barang         : ");
            String deskripsiBarang = scanner.nextLine();

            System.out.print("Masukkan Lokasi Terakhir/Ditemukan: ");
            String lokasi = scanner.nextLine();

            Item item = new Item(namaBarang, deskripsiBarang, lokasi, "Reported");

            reportedItems.add(item);

            System.out.println("\n" + green(">> Laporan berhasil dicatat:"));
            System.out.println("Barang   : " + item.getNama());
            System.out.println("Deskripsi: " + item.getDeskripsi());
            System.out.println("Lokasi   : " + item.getLokasi());
            System.out.println("Status   : " + yellow(item.getStatus()));

        } catch (Exception e) {
            System.out.println(red("Terjadi kesalahan saat memasukkan data. Silakan coba lagi."));
        }
    }

    @Override
    public void viewReportedItem() {
        if (reportedItems.isEmpty()) {
            System.out.println(yellow(">> Belum ada laporan barang."));
        } else {
            System.out.println("\n" + cyan("=== Daftar Barang Dilaporkan ==="));
            System.out.printf("%-4s %-20s %-30s %-25s %-10s%n", "No", "Nama Barang", "Deskripsi", "Lokasi", "Status");
            System.out.println(
                    "----------------------------------------------------------------------------------------------");

            int no = 1;
            for (Item item : reportedItems) {
                System.out.printf("%-4d %-20s %-30s %-25s %-10s%n",
                        no++,
                        item.getNama(),
                        item.getDeskripsi(),
                        item.getLokasi(),
                        item.getStatus());
            }
        }
    }

    @Override
    public void displayAppMenu(Scanner scanner) {
        int pilihan = -1;

        do {
            System.out.println("\n" + cyan("=== Menu Mahasiswa ==="));
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");

            try {
                pilihan = Integer.parseInt(scanner.nextLine());

                switch (pilihan) {
                    case 1:
                        reportItem(scanner);
                        break;
                    case 2:
                        viewReportedItem();
                        break;
                    case 0:
                        System.out.println(green("Logout berhasil.\n"));
                        break;
                    default:
                        System.out.println(red("Pilihan tidak valid. Silakan coba lagi."));
                }
            } catch (NumberFormatException e) {
                System.out.println(red("Input harus berupa angka. Silakan coba lagi."));
            }

        } while (pilihan != 0);
    }
}