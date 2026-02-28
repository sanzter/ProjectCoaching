import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class project {

    // Deklarasi Variable
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String[] nama = new String[3];
    static int[] jumlah = new int[3];
    static int[] total = new int[3];
    static int harga = 10000;

    public static void main(String[] args) throws IOException {
        int pilihan;

        do {
            System.out.println("\n--- Pemesan Kue Toko Kue Sejahtera ---");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampilkan Data");
            System.out.println("3. Ubah Data");
            System.out.println("4. Hapus Data");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = Integer.parseInt(br.readLine());

            switch (pilihan) {
                case 1 -> tambahData();
                case 2 -> tampilData();
                case 3 -> ubahData();
                case 4 -> hapusData();
                case 5 -> System.out.println("Program selesai");
                default -> System.out.println("Menu tidak valid");
            }
        } while (pilihan != 5);
    }

    // Menambahkah Data
    static void tambahData() throws IOException {
        for (int i = 0; i < nama.length; i++) {
            if (nama[i] == null) {
                System.out.print("Nama Pemesan: ");
                nama[i] = br.readLine();
                System.out.print("Jumlah Pesanan: ");
                jumlah[i] = Integer.parseInt(br.readLine());
                total[i] = jumlah[i] * harga;
                System.out.println("Data berhasil ditambahkan");
                return;
            }
        }
        System.out.println("Data penuh!");
    }

    // Membaca Data
    static void tampilData() {
        System.out.println("\n--- Data Pesanan ---");
        for (int i = 0; i < nama.length; i++) {
            if (nama[i] != null) {
                System.out.println((i + 1) + ". " + nama[i]
                        + " | Jumlah: " + jumlah[i]
                        + " | Total: Rp." + total[i]);
            }
        }
    }

    // Memperbarui Data
    static void ubahData() throws IOException {
        tampilData();
        System.out.print("Pilih nomor data yang diubah: ");
        int index = Integer.parseInt(br.readLine()) - 1;

        if (index >= 0 && index < nama.length && nama[index] != null) {
            System.out.print("Nama baru: ");
            nama[index] = br.readLine();
            System.out.print("Jumlah baru: ");
            jumlah[index] = Integer.parseInt(br.readLine());
            total[index] = jumlah[index] * harga;
            System.out.println("Data berhasil diubah");
        } else {
            System.out.println("Data tidak valid");
        }
    }

    // Menghapus Data
    static void hapusData() throws IOException {
        tampilData();
        System.out.print("Pilih nomor data yang dihapus: ");
        int index = Integer.parseInt(br.readLine()) - 1;

        if (index >= 0 && index < nama.length && nama[index] != null) {
            nama[index] = null;
            jumlah[index] = 0;
            total[index] = 0;
            System.out.println("Data berhasil dihapus");
        } else {
            System.out.println("Data tidak valid");
        }
    }
}
