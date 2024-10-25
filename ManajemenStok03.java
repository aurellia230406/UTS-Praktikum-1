import java.util.Scanner;

class Barang {
    String nama;
    int jumlahStok;
    double hargaPerUnit;

    Barang(String nama, int jumlahStok, double hargaPerUnit) {
        this.nama = nama;
        this.jumlahStok = jumlahStok;
        this.hargaPerUnit = hargaPerUnit;
    }

    double totalNilaiStok() {
        return jumlahStok * hargaPerUnit;
    }

    boolean cekStok(int jumlahPermintaan) {
        return jumlahStok >= jumlahPermintaan;
    }

    void kurangiStok(int jumlah) {
        jumlahStok -= jumlah;
    }

    void tambahStok(int jumlah) {
        jumlahStok += jumlah;
    }
}

public class ManajemenStok03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Masukkan nama barang (atau ketik 'selesai' untuk berhenti): ");
            String nama = scanner.nextLine();
            if (nama.equalsIgnoreCase("selesai")) {
                break;
            }

            System.out.print("Masukkan jumlah stok: ");
            int jumlahStok = scanner.nextInt();

            System.out.print("Masukkan harga per unit: ");
            double hargaPerUnit = scanner.nextDouble();
            scanner.nextLine(); // konsumsi newline

            Barang barang = new Barang(nama, jumlahStok, hargaPerUnit);
            System.out.println("Total nilai stok: " + barang.totalNilaiStok());

            while (true) {
                System.out.print("Masukkan jumlah permintaan (atau ketik '0' untuk berhenti): ");
                int jumlahPermintaan = scanner.nextInt();
                scanner.nextLine(); // konsumsi newline

                if (jumlahPermintaan == 0) {
                    break;
                }

                if (barang.cekStok(jumlahPermintaan)) {
                    barang.kurangiStok(jumlahPermintaan);
                    System.out.println("Permintaan dapat dipenuhi. Jumlah stok sekarang: " + barang.jumlahStok);
                } else {
                    System.out.println("Stok tidak mencukupi.");
                }
            }

            System.out.print("Apakah Anda ingin menyesuaikan stok? (ya/tidak): ");
            String penyesuaian = scanner.nextLine();
            if (penyesuaian.equalsIgnoreCase("ya")) {
                System.out.print("Masukkan jumlah untuk menambah stok (gunakan angka negatif untuk mengurangi stok): ");
                int jumlahPenyesuaian = scanner.nextInt();
                scanner.nextLine(); // konsumsi newline

                if (jumlahPenyesuaian > 0) {
                    barang.tambahStok(jumlahPenyesuaian);
                } else {
                    barang.kurangiStok(-jumlahPenyesuaian);
                }

                System.out.println("Jumlah stok setelah penyesuaian: " + barang.jumlahStok);
            }

            System.out.println("Data barang:");
            System.out.println("Nama: " + barang.nama);
            System.out.println("Jumlah stok: " + barang.jumlahStok);
            System.out.println("Harga per unit: " + barang.hargaPerUnit);
            System.out.println("Total nilai stok: " + barang.totalNilaiStok());
        }

        scanner.close();
    }
}