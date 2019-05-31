import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
ID: ny834271
LANG: JAVA
TASK: friday
 */
public class friday {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("friday.in"));
        int n = scanner.nextInt();
        // from Sunday to Saturday
        int[] counts = new int[7];
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int beginDay = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            int year = 1900 + i;
            boolean isLeap = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
            if (isLeap) {
                days[1] = 29;
            } else {
                days[1] = 28;
            }

            for (int day : days) {
                int weekDay = (beginDay + sum + 12) % 7;
                counts[weekDay]++;
                sum += day;
            }
        }

        PrintWriter writer = new PrintWriter(new File("friday.out"));
        writer.print(counts[6]);
        System.out.print(counts[6]);
        for (int i = 0; i < 6; i++) {
            System.out.print(" " + counts[i]);
            writer.print(" " + counts[i]);
        }
        System.out.println();
        writer.println();
        writer.close();
    }

}
