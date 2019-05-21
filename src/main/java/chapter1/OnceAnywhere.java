package chapter1;

import java.io.File;
import java.io.IOException;

/**
 * <pre>
 * "Write Once, Run Anywhere" - what does it mean in real life?
 * “一次编写，到处运行”，还是“一次编写，到处调试”
 * https://en.wikipedia.org/wiki/Write_once,_run_anywhere
 * </pre>
 */
public class OnceAnywhere {

    public static void main(String[] args) {
        existsOrNot();
        succeedOrNot();
    }

    private static void existsOrNot() {
        String[] paths = {
            // \ will only work under Windows
            "data\\chapter1\\periodic-table-of-elements.csv",
            // / will work under both Windows and Linux
            "data/chapter1/periodic-table-of-elements.csv",
            // work only under windows, Linux is case sensitive
            "data/chapter1/PERIODIC-TABLE-OF-ELEMENTS.csv",
            // a general approach on system dependent factors
            "data" + File.separator + "chapter1" + File.separator + "periodic-table-of-elements.csv"
        };

        for (String path : paths) {
            String fullPath = new File(path).getAbsolutePath();
            System.out.println(fullPath + (new File(path).exists() ? " exists." : " does not exist."));
        }
    }

    private static void succeedOrNot() {
        File dir = new File("data/chapter1");
        try {
            ProcessBuilder pb = new ProcessBuilder().directory(dir);
            Process process;
            if (System.getProperty("os.name").startsWith("Windows")) {
                process = pb.command("cmd", "/c", "sqlite3 sample.db < import.sql").start();
            } else {
                process = pb.command("bash", "-c", "sqlite3 sample.db < import.sql").start();
            }
            process.waitFor();
            System.out.println("Finished with return code " + process.exitValue());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        try {
            // Only works under Linux if sqlite3 package was installed
            Process process = new ProcessBuilder("bash", "-c", "sqlite3 sample.db < import.sql").directory(dir).start();
            process.waitFor();
            System.out.println("Finished with return code " + process.exitValue());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
