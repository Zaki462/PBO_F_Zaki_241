// Kelas Hewan
class Hewan {
    // Atribut
    String nama;
    String jenis;
    String suara;
    String warna;  // Variabel tambahan
    int umur;      // Variabel tambahan

    // Constructor
    Hewan(String nama, String jenis, String suara, String warna, int umur) {
        this.nama = nama;
        this.jenis = jenis;
        this.suara = suara;
        this.warna = warna;
        this.umur = umur;
    }

    // Method untuk menampilkan informasi hewan
    void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Jenis: " + jenis);
        System.out.println("Suara: " + suara);
        System.out.println("Umur: " + umur);
    }
}

// Kelas Main
public class KelasHewanMain {
    public static void main(String[] args) {
        // Membuat objek hewan1 dan hewan2 dengan variabel tambahan
        Hewan hewan1 = new Hewan("Kucing", "Mamalia", "Nyann~~", "Putih", 2);
        Hewan hewan2 = new Hewan("Anjing", "Mamalia", "Woof-Woof!!", "Coklat", 3);

        // Menampilkan informasi kedua hewan
        hewan1.tampilkanInfo();
        hewan2.tampilkanInfo();
    }
}