package com.praktikum.users;

import com.praktikum.actions.AdminAction;
import com.praktikum.models.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.praktikum.models.ItemManager.reportedItems;

public class Admin extends User implements AdminAction {

    private String password;
    private static final List<Admin> daftarAdmin = new ArrayList<>();

    static {
        daftarAdmin.add(new Admin("Admin241", "Password241"));
        daftarAdmin.add(new Admin("master", "master241"));
    }

    public Admin(String nama, String password) {
        super(nama);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean login(String inputNama, String inputPassword) {
        return daftarAdmin.stream()
                .anyMatch(admin -> admin.getNama().equalsIgnoreCase(inputNama)
                        && admin.getPassword().equals(inputPassword));
    }

    @Override
    public void manageItem() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        while (true) {
            System.out.println(ConsoleColor.blue("\n=== Kelola Barang ==="));
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil");
            System.out.println("0. Kembali");
            System.out.print(ConsoleColor.cyan("Pilih menu: "));

            try {
                pilihan = Integer.parseInt(scanner.nextLine());

                switch (pilihan) {
                    case 1:
                        lihatSemuaLaporan();
                        break;
                    case 2:
                        tandaiBarangClaimed(scanner);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println(ConsoleColor.red(">> Pilihan tidak valid."));
                }
            } catch (NumberFormatException e) {
                System.out.println(ConsoleColor.red(">> Input tidak valid. Harus berupa angka."));
            }
        }
    }

    private void lihatSemuaLaporan() {
        if (reportedItems.isEmpty()) {
            System.out.println(ConsoleColor.red(">> Tidak ada laporan barang."));
            return;
        }

        System.out.println(ConsoleColor.blue("\n=== Semua Laporan Barang ==="));
        System.out.printf(ConsoleColor.yellow("%-4s %-20s %-30s %-20s %-10s\n"),
                "No", "Nama", "Deskripsi", "Lokasi", "Status");
        System.out.println(ConsoleColor.yellow("=".repeat(90)));

        int no = 1;
        for (Item item : reportedItems) {
            System.out.printf("%-4d %-20s %-30s %-20s %-10s\n", no++,
                    item.getNama(), item.getDeskripsi(), item.getLokasi(), item.getStatus());
        }
    }

    private void tandaiBarangClaimed(Scanner scanner) {
        List<Item> reportedOnly = new ArrayList<>();
        for (Item item : reportedItems) {
            if (item.getStatus().equalsIgnoreCase("Reported")) {
                reportedOnly.add(item);
            }
        }

        if (reportedOnly.isEmpty()) {
            System.out.println(ConsoleColor.red(">> Tidak ada barang dengan status 'Reported'."));
            return;
        }

        System.out.println(ConsoleColor.blue("\n=== Barang yang Belum Diambil ==="));
        for (int i = 0; i < reportedOnly.size(); i++) {
            Item item = reportedOnly.get(i);
            System.out.printf(ConsoleColor.purple("%d. %s - %s - Lokasi: %s\n"),
                    i + 1, item.getNama(), item.getDeskripsi(), item.getLokasi());
        }

        System.out.print(ConsoleColor.cyan("Masukkan nomor barang yang ingin ditandai sebagai 'Claimed': "));
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            Item selectedItem = reportedOnly.get(index);
            selectedItem.setStatus(ConsoleColor.green("Claimed"));
            System.out.println(ConsoleColor.green(">> Status barang berhasil diperbarui menjadi 'Claimed'."));
        } catch (NumberFormatException e) {
            System.out.println(ConsoleColor.red(">> Input harus berupa angka."));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(ConsoleColor.red(">> Indeks tidak valid. Silakan coba lagi."));
        }
    }

    @Override
    public void manageUser() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        while (true) {
            System.out.println(ConsoleColor.blue("\n=== Kelola Mahasiswa ==="));
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("3. Lihat Daftar Mahasiswa");
            System.out.println("0. Kembali");
            System.out.print(ConsoleColor.cyan("Pilih menu: "));

            try {
                pilihan = Integer.parseInt(scanner.nextLine());

                switch (pilihan) {
                    case 1:
                        tambahMahasiswa(scanner);
                        break;
                    case 2:
                        hapusMahasiswa(scanner);
                        break;
                    case 3:
                        tampilkanDaftarMahasiswa();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println(ConsoleColor.red(">> Pilihan tidak valid."));
                }

            } catch (NumberFormatException e) {
                System.out.println(ConsoleColor.red(">> Input tidak valid. Harus berupa angka."));
            }
        }
    }

    private void tambahMahasiswa(Scanner scanner) {
        System.out.print(ConsoleColor.cyan("Masukkan nama mahasiswa: "));
        String nama = scanner.nextLine();

        System.out.print(ConsoleColor.cyan("Masukkan NIM mahasiswa: "));
        String nim = scanner.nextLine();

        for (Mahasiswa m : Mahasiswa.daftarMahasiswa) {
            if (m.getNim().equalsIgnoreCase(nim)) {
                System.out.println(ConsoleColor.red(">> Mahasiswa dengan NIM tersebut sudah terdaftar."));
                return;
            }
        }

        new Mahasiswa(nama, nim);
        System.out.println(ConsoleColor.green(">> Mahasiswa berhasil ditambahkan."));
    }

    private void hapusMahasiswa(Scanner scanner) {
        tampilkanDaftarMahasiswa();

        System.out.print(ConsoleColor.cyan("Masukkan NIM mahasiswa yang ingin dihapus: "));
        String nim = scanner.nextLine();

        boolean ditemukan = false;

        for (int i = 0; i < Mahasiswa.daftarMahasiswa.size(); i++) {
            if (Mahasiswa.daftarMahasiswa.get(i).getNim().equalsIgnoreCase(nim)) {
                Mahasiswa.daftarMahasiswa.remove(i);
                System.out.println(ConsoleColor.green(">> Mahasiswa dengan NIM " + nim + " berhasil dihapus."));
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println(ConsoleColor.red(">> Mahasiswa dengan NIM tersebut tidak ditemukan."));
        }
    }

    private void tampilkanDaftarMahasiswa() {
        System.out.println(ConsoleColor.blue("\n=== Daftar Mahasiswa Terdaftar ==="));

        if (Mahasiswa.daftarMahasiswa.isEmpty()) {
            System.out.println(ConsoleColor.red(">> Belum ada mahasiswa terdaftar."));
            return;
        }

        int index = 1;
        for (Mahasiswa m : Mahasiswa.daftarMahasiswa) {
            System.out.printf(ConsoleColor.yellow("%d. %s (NIM: %s)\n"), index++, m.getNama(), m.getNim());
        }
    }

    @Override
    public void displayAppMenu(Scanner scanner) {
        int pilihan;

        while (true) {
            System.out.println(ConsoleColor.blue("\n=== Menu Admin ==="));
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print(ConsoleColor.cyan("Pilih menu: "));

            try {
                pilihan = Integer.parseInt(scanner.nextLine());

                switch (pilihan) {
                    case 1:
                        manageItem();
                        break;
                    case 2:
                        manageUser();
                        break;
                    case 0:
                        System.out.println(ConsoleColor.green(">> Logout berhasil.\n"));
                        return;
                    default:
                        System.out.println(ConsoleColor.red(">> Pilihan tidak valid. Silakan coba lagi."));
                }

            } catch (NumberFormatException e) {
                System.out.println(ConsoleColor.red(">> Input tidak valid. Harus berupa angka."));
            }
        }
    }
}