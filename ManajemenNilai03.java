import java.util.ArrayList;
import java.util.Scanner;

public class ManajemenNilai03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Double> studentGrades = new ArrayList<>();
        
        double totalGrades = 0;
        int countAboveAverage = 0, countBelowAverage = 0;
        String inputName;
        double inputGrade;
        
        while (true) {
            System.out.print("Masukkan nama siswa (atau ketik 'selesai' untuk mengakhiri): ");
            inputName = scanner.nextLine();
            
            if (inputName.equalsIgnoreCase("selesai")) {
                break;
            }
            
            System.out.print("Masukkan nilai siswa: ");
            inputGrade = scanner.nextDouble();
            scanner.nextLine();
            
            studentNames.add(inputName);
            studentGrades.add(inputGrade);
            totalGrades += inputGrade;
        }
        
        if (studentGrades.size() > 0) {
            double average = totalGrades / studentGrades.size();
            System.out.printf("Rata-rata nilai kelas: %.2f\n", average);
            
            for (double grade : studentGrades) {
                if (grade > average) {
                    countAboveAverage++;
                } else {
                    countBelowAverage++;
                }
            }
            
            System.out.println("Jumlah siswa dengan nilai di atas rata-rata: " + countAboveAverage);
            System.out.println("Jumlah siswa dengan nilai di bawah rata-rata: " + countBelowAverage);
            
            if (countAboveAverage > studentGrades.size() / 2) {
                System.out.println("Mayoritas siswa memiliki nilai di atas rata-rata.");
            } else {
                System.out.println("Mayoritas siswa tidak memiliki nilai di atas rata-rata.");
            }
        } else {
            System.out.println("Tidak ada data siswa yang dimasukkan.");
        }
        
        scanner.close();
    }
}