package chapter5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * <pre>
 * A simple demo of large file processing:
 * File size: 54.34GB. 82677139 lines scanned in 496.77S
 * {
 *  "reviewerID": "A3AF8FFZAZYNE5", "asin": "0000000078",
 *  "helpful": [1, 1],
 *  "reviewText": "It totally changed my life. I would recommend it to anyone who is seeking. I approach living differently, I enjoy life more. Unbelievable! A MUST READ!!!",
 *  "overall": 5.0,
 *  "summary": "Impactful!",
 *  "unixReviewTime": 1092182400, "reviewTime": "08 11, 2004"
 * }
 * </pre>
 */
public class BigFileDemo {

    public static void main(String[] args) {
        String path = "E:\\Data Science\\item_dedup.json";
        File file = new File(path);
        double size = file.length() / (1024 * 1024 * 1024d);
        long now = System.currentTimeMillis();
        int count = 0;
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(file.getParent(), "item_5_stars.json"))) {
            String line;
            while ((line = reader.readLine()) != null && count < 1000) {
                if (line.contains("\"overall\": 5.0")) {
                    count++;
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("Process %.2fGB file and write %d lines in %.2fS%n",
            size, count, (System.currentTimeMillis() - now) / 1000.0);

        now = System.currentTimeMillis();
        try (PrintWriter writer = new PrintWriter(new File(file.getParent(), "item_5_stars.json"))) {
            Files.lines(Path.of(path))
                .filter(line -> line.contains("\"overall\": 5.0"))
                .forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("Process %.2fGB file in %.2fS%n", size, (System.currentTimeMillis() - now) / 1000.0);
    }

}
