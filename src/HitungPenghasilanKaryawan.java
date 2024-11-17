import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class HitungPenghasilanKaryawan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Deklarasi variabel
        String golongan;
        float jamLembur;
        double gajiPokok = 0, gajiLembur = 0, jumlahPenghasilan;

        // Input golongan dengan validasi
        do {
            System.out.print("Masukkan Golongan (A/B/C): ");
            golongan = input.next().toUpperCase();

            if (golongan.equals("A")) {
                gajiPokok = 5000000;
            } else if (golongan.equals("B")) {
                gajiPokok = 6500000;
            } else if (golongan.equals("C")) {
                gajiPokok = 9500000;
            } else {
                System.out.println("Golongan tidak valid! Silakan masukkan ulang.");
            }
        } while (!golongan.equals("A") && !golongan.equals("B") && !golongan.equals("C"));

        // Input jam lembur
        System.out.print("Masukkan Jam Lembur: ");
        jamLembur = input.nextFloat();

        // Hitung Gaji Lembur berdasarkan rentang jam lembur
        if (jamLembur >= 1 && jamLembur < 2) {
            gajiLembur = gajiPokok * 0.30;
        } else if (jamLembur >= 2 && jamLembur < 3) {
            gajiLembur = gajiPokok * 0.32;
        } else if (jamLembur >= 3 && jamLembur < 4) {
            gajiLembur = gajiPokok * 0.34;
        } else if (jamLembur >= 4 && jamLembur < 5) {
            gajiLembur = gajiPokok * 0.36;
        } else if (jamLembur >= 5){
            gajiLembur = gajiPokok * 0.38;
        } else {
            gajiLembur = 0; // Jika tidak ada lembur
        }

        // Hitung Jumlah Penghasilan
        jumlahPenghasilan = gajiPokok + gajiLembur;

        // Format jumlah penghasilan menggunakan NumberFormat
        NumberFormat formatter = NumberFormat.getNumberInstance(new Locale("id", "ID"));
        String formattedPenghasilan = formatter.format(jumlahPenghasilan);

        // Output hasil
        System.out.println("Jumlah Penghasilan: Rp " + formattedPenghasilan);

        input.close();
    }
}
