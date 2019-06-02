import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
ID: ny834271
LANG: JAVA
TASK: gift1
 */
public class gift1 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("gift1.in"));
             PrintWriter printWriter = new PrintWriter(new File("gift1.out"))) {
            int n = scanner.nextInt();
            String[] names = new String[n];
            Map<String, Integer> balances = new HashMap<>();
            for (int i = 0; i < n; i++) {
                names[i] = scanner.next();
                balances.put(names[i], 0);
            }

            while (scanner.hasNext()) {
                String giver = scanner.next();
                int amount = scanner.nextInt();
                int receivers = scanner.nextInt();
                if (receivers == 0)
                    continue;

                int money = amount / receivers;
                for (int i = 0; i < receivers; i++) {
                    String receiverName = scanner.next();
                    balances.put(receiverName, balances.get(receiverName) + money);
                }

                balances.put(giver, balances.get(giver) - amount + amount % receivers);
            }

            for (String name : names) {
                printWriter.println(name + " " + balances.get(name));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
