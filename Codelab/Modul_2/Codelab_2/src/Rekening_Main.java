class RekeningBank {
    private String nomorRekening;
    private String namaPemilik;
    private double saldo;

    // Constructor
    public RekeningBank(String nomorRekening, String namaPemilik, double saldo) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    // Menampilkan informasi rekening
    public void tampilkanInfo() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: Rp" + saldo);
        System.out.println();
    }

    // Menambah saldo
    public void setor(double jumlah) {
        saldo += jumlah;
        System.out.println("Setor tunai sebesar Rp" + jumlah + " berhasil.");
        System.out.println("Saldo sekarang: Rp" + saldo);
        System.out.println();
    }

    // Mengurangi saldo jika mencukupi
    public void tarik(double jumlah) {
        if (saldo >= jumlah) {
            saldo -= jumlah;
            System.out.println("Tarik tunai sebesar Rp" + jumlah + " berhasil.");
            System.out.println("Saldo sekarang: Rp" + saldo);
        } else {
            System.out.println("Saldo tidak mencukupi untuk menarik Rp" + jumlah);
        }
        System.out.println();
    }
}

public class Rekening_Main {
    public static void main(String[] args) {
        // Membuat dua objek rekening
        RekeningBank rekening1 = new RekeningBank("202410370110241", "Ahmad Zaki", 5000000);
        RekeningBank rekening2 = new RekeningBank("987654321", "Bagas", 3000000);

        // Menampilkan informasi rekening
        System.out.println("Informasi rekening pertama:");
        rekening1.tampilkanInfo();

        System.out.println("Informasi rekening kedua:");
        rekening2.tampilkanInfo();

        // Setor dan tarik saldo
        rekening1.setor(1000000);
        rekening1.tarik(2000000);

        rekening2.setor(500000);
        rekening2.tarik(4000000);
    }
}
