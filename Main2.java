import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main2 {
    public static void main(String[] args) {
        String csvFile = args[0];
        String line;
        double toplami= 0.0;
        int sayi = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
               // if (data.length == 7 && !data[3].equals("GPA")) {
                   // double gpa = Double.parseDouble(data[3]);
                  //  toplami += gpa;
                  //  sayi++;
               // }
               if(data.length == 7 && data[4].equals("Sociology"))
               {
                double gpa = Double.parseDouble(data[3]);
                 toplami += gpa;
                 sayi++;

               }
            }
            double ortalama = toplami / sayi;
            System.out.println("Ogrenci ortalamasi: " + ortalama);
        } catch (IOException e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}