import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String csvFile = args[0];
        String line;
        double sum = 0.0;
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 7 && !data[3].equals("GPA")) {
                    double gpa = Double.parseDouble(data[3]);
                    sum += gpa;
                    count++;
                }
            }
            double average = sum / count;
            System.out.println("Ogrenci ortalamasi: " + average);
        } catch (IOException e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}