package app;

import Perpustakaan.*;

public class Main {
    public static void main(String[] args) {
        Buku buku1 = new Fiksi("Laskar Pelangi", "Andrea Hirata");
        Buku buku2 = new NonFiksi("Filosofi Teras", "Henry Manampiring");

        buku1.displayInfo();
        System.out.println();
        buku2.displayInfo();
        System.out.println();

        Anggota anggota1 = new Anggota("Zaki", "241");
        Anggota anggota2 = new Anggota("Hamdan", "223");

        anggota1.pinjamBuku("Laskar Pelangi");
        anggota2.pinjamBuku("Filosofi Teras", 7);
        System.out.println();
        anggota1.kembalikanBuku("Laskar Pelangi");
    }
}
