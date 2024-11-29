import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class HitungPenghasilanKaryawanArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Array gaji untuk Golongan A, B, dan C
        double[] gajiGolongan = {5000000, 6500000, 9500000};

        // Array persentase lembur
        double[] persentaseLembur = {0.30, 0.32, 0.34, 0.36, 0.38};
        
        // Mendeklarasikan variabel
        String golongan;
        float jamLembur;
        double gajiPokok = 0, gajiLembur = 0, jumlahPenghasilan;

        // Validasi input golongan
        int indexGolongan = -1; // Ini untuk menentukan array golongan gaji yang diambil
        do {
            System.out.print("Masukkan Golongan (A/B/C): ");
            golongan = input.next().toUpperCase();
            
            if (golongan.equals("A")) {
                indexGolongan = 0;
            } else if (golongan.equals("B")) {
                indexGolongan = 1;
            } else if (golongan.equals("C")) {
                indexGolongan = 2;
            } else {
                System.out.println("Golongan tidak valid! Silakan masukkan ulang.");
            }
        } while (indexGolongan == -1);

        // Ambil gaji dari array berdasarkan index
        gajiPokok = gajiGolongan[indexGolongan];

        // Input jam lembur
        System.out.print("Masukkan Total Jam Lembur: ");
        jamLembur = input.nextFloat();

        // Menghitung gaji lembur menggunakan array persentase
        if (jamLembur >=1 && jamLembur < 2) {
            gajiLembur = gajiPokok * persentaseLembur[0];
        } else if (jamLembur >= 2 && jamLembur < 3) {
            gajiLembur = gajiPokok * persentaseLembur[1];
        } else if (jamLembur >= 3 && jamLembur < 4) {
            gajiLembur = gajiPokok * persentaseLembur[2];
        } else if (jamLembur >= 4 && jamLembur < 5) {
            gajiLembur = gajiPokok * persentaseLembur[3];
        } else if (jamLembur >= 5) {
            gajiLembur = gajiPokok * persentaseLembur[4];
        } else {
            gajiLembur = 0; // Jika tidak ada lemburan
        }

        // Hitung jumlah penghasilan
        jumlahPenghasilan = gajiPokok + gajiLembur;

        NumberFormat formatter = NumberFormat.getNumberInstance(new Locale("id", "ID"));
        String formattedPenghasilan = formatter.format(jumlahPenghasilan);

        // Menampilkan output hasil
        System.out.println("Jumlah Penghasilan: Rp " + formattedPenghasilan);


        input.close();
    }
}
