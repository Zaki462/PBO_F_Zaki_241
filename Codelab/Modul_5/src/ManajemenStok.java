import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManajemenStok {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Data awal
        daftarBarang.add(new Barang("Pensil", 10));
        daftarBarang.add(new Barang("Buku", 5));
        daftarBarang.add(new Barang("Penghapus", 8));

        boolean running = true;

        while (running) {
            System.out.println("\n=== MENU MANAJEMEN STOK ===");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("4. Hapus Barang");
            System.out.println("5. Total Semua Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = -1;
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // Konsumsi newline
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama barang: ");
                    String nama = scanner.nextLine();

                    try {
                        System.out.print("Masukkan jumlah stok awal: ");
                        int stokAwal = scanner.nextInt();
                        scanner.nextLine(); // konsumsi newline
                        daftarBarang.add(new Barang(nama, stokAwal));
                        System.out.println("Barang berhasil ditambahkan.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input stok harus berupa angka!");
                        scanner.nextLine(); // clear buffer
                    }
                    break;

                case 2:
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                    } else {
                        System.out.println("\n=== DAFTAR BARANG ===");
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            Barang b = daftarBarang.get(i);
                            System.out.println(i + ". " + b.getNama() + " (Stok: " + b.getStok() + ")");
                        }
                    }
                    break;

                case 3:
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Tidak ada barang untuk dikurangi stoknya.");
                        break;
                    }

                    try {
                        System.out.println("\n=== DAFTAR BARANG ===");
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            Barang b = daftarBarang.get(i);
                            System.out.println(i + ". " + b.getNama() + " (Stok: " + b.getStok() + ")");
                        }

                        System.out.print("Pilih nomor barang: ");
                        int idx = scanner.nextInt();

                        Barang barang = daftarBarang.get(idx);

                        System.out.print("Masukkan jumlah yang ingin diambil: ");
                        int jumlah = scanner.nextInt();
                        scanner.nextLine(); // konsumsi newline

                        if (jumlah > barang.getStok()) {
                            throw new StokTidakCukupException("Stok untuk " + barang.getNama() +
                                    " hanya tersisa " + barang.getStok());
                        }

                        barang.setStok(barang.getStok() - jumlah);
                        System.out.println("Stok berhasil dikurangi.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka!");
                        scanner.nextLine();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Nomor barang tidak valid.");
                    } catch (StokTidakCukupException e) {
                        System.out.println("Gagal: " + e.getMessage());
                    }
                    break;

                case 4:
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Tidak ada barang untuk dihapus.");
                        break;
                    }

                    try {
                        System.out.println("\n=== DAFTAR BARANG ===");
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            Barang b = daftarBarang.get(i);
                            System.out.println(i + ". " + b.getNama() + " (Stok: " + b.getStok() + ")");
                        }

                        System.out.print("Masukkan nomor barang yang ingin dihapus: ");
                        int idxHapus = scanner.nextInt();
                        scanner.nextLine(); // konsumsi newline

                        Barang barangDihapus = daftarBarang.remove(idxHapus);
                        System.out.println("Barang \"" + barangDihapus.getNama() + "\" berhasil dihapus.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka!");
                        scanner.nextLine();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Nomor barang tidak valid.");
                    }
                    break;

                case 5:
                    int totalStok = 0;
                    for (Barang b : daftarBarang) {
                        totalStok += b.getStok();
                    }
                    System.out.println("Total seluruh stok barang: " + totalStok);
                    break;

                case 0:
                    System.out.println("Terima kasih!");
                    running = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}
