import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main5 {
  public static void main(String[] args) {
    String csvFile = args[0];
    String line;

    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
      int average = 0;
      int targetGPA = 302; // Değer, ondalıklı kısımdan arındırıldı.

      // Dizi oluşturuldu.
      int[] GPAs = new int[10000];
      int count = 0;

      while ((line = br.readLine()) != null) {
        String[] data = line.split(",");
        if (data.length == 7 && !data[3].equals("GPA")) {
          // GPAs dizisi dolduruldu.
          int gpa = (int) (Double.parseDouble(data[3]) * 100);
          GPAs[count++] = gpa;
        }
      }
      // 3.02 notuna sahip öğrencilerin sayısı binary search ile hesaplandı.
      int index = binarySearch(GPAs, 0, count - 1, targetGPA);
      if (index != -1) {
        int leftIndex = index;
        while (leftIndex >= 0 && GPAs[leftIndex] == targetGPA) {
          average++;
          leftIndex--;
        }

        int rightIndex = index + 1;
        while (rightIndex < count && GPAs[rightIndex] == targetGPA) {
          average++;
          rightIndex++;
        }
      }

      System.out.println(average);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  // Binary search algoritması eklendi.
  public static int binarySearch(int[] arr, int left, int right, int target) {
    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return -1;
  }
}