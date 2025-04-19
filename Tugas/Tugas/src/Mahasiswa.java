public class Mahasiswa extends User {

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
}