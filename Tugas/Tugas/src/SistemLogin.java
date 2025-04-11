import java.util.Scanner; // Mengimpor kelas Scanner untuk input dari pengguna

// Kelas Admin untuk login sebagai admin
class Admin {
    // Atribut tetap (konstanta) untuk menyimpan username dan password admin
    private final String USERNAME = "admin241";
    private final String PASSWORD = "password241";

    // Method untuk mengecek apakah login admin berhasil
    public boolean login(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }
}

// Kelas Mahasiswa untuk login sebagai mahasiswa
class Mahasiswa {

    // Atribut tetap (konstanta) untuk nama dan NIM mahasiswa
    private final String nama = "Ahmad Fakhruddin Zaki";
    private final String nim = "202410370110241";

    // Method untuk mengecek apakah login mahasiswa berhasil
    public boolean login(String inputNama, String inputNim) {
        return inputNama.equals(nama) && inputNim.equals(nim);
    }

    // Method untuk menampilkan informasi mahasiswa setelah login berhasil
    public void displayInfo() {
        System.out.println("Login berhasil sebagai Mahasiswa.");
        System.out.println("Nama: " + nama);
        System.out.println("NIM : " + nim);
    }
}

// Kelas utama yang menjalankan sistem login
class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk input

        Admin admin = new Admin();           // Membuat objek Admin
        Mahasiswa mahasiswa = new Mahasiswa(); // Membuat objek Mahasiswa

        // Menu pilihan login
        System.out.println("=== Sistem Login ===");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.print("Pilih opsi (1/2): ");
        int pilihan = scanner.nextInt(); // Membaca pilihan user
        scanner.nextLine(); // Membersihkan newline setelah nextInt()

        switch (pilihan) {
            case 1:
                // Login sebagai Admin
                System.out.print("Masukkan Username Admin: ");
                String username = scanner.nextLine(); // Input username admin
                System.out.print("Masukkan Password Admin: ");
                String password = scanner.nextLine(); // Input password admin

                // Cek login admin
                if (admin.login(username, password)) {
                    System.out.println("Login berhasil sebagai Admin.");
                } else {
                    System.out.println("Username atau Password salah.");
                }
                break;

            case 2:
                // Login sebagai Mahasiswa
                System.out.print("Masukkan Nama Mahasiswa: ");
                String nama = scanner.nextLine(); // Input nama mahasiswa
                System.out.print("Masukkan NIM Mahasiswa: ");
                String nim = scanner.nextLine(); // Input NIM mahasiswa

                // Cek login mahasiswa
                if (mahasiswa.login(nama, nim)) {
                    mahasiswa.displayInfo(); // Tampilkan data mahasiswa jika berhasil login
                } else {
                    System.out.println("Nama atau NIM salah.");
                }
                break;

            default:
                // Jika user memasukkan pilihan yang tidak valid
                System.out.println("Pilihan tidak valid.");
        }

        scanner.close(); // Menutup Scanner
    }
}
