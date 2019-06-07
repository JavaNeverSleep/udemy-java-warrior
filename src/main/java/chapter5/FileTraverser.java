package chapter5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileTraverser {

    public static void main(String[] args) throws IOException {
        File file = new File("").getCanonicalFile();
        boolean nio = args.length > 0 && args[0].startsWith("NIO");
        traverse(file, 0, nio);
    }

    private static void traverse(File file, int level, boolean nio) {
        if (level > 0) System.out.print("|  ".repeat(level - 1));
        System.out.println((level > 0 ? "|__" : "") + file.getName());
        if (!file.isDirectory()) return;

        if (nio) {
            try {
                Files.newDirectoryStream(file.toPath()).forEach(f -> traverse(f.toFile(), level + 1, true));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            File[] children = file.listFiles();
            if (children != null && children.length > 0) {
                for (File child : children) {
                    traverse(child, level + 1, false);
                }
            }
        }
    }

}
