package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {

    public static void main(String[] args) throws IOException {

        Path path1 = Paths.get("firstpath.txt");
        Path path2 = Paths.get("secondpath.txt");
        Path finalPath = Paths.get("finalpath.txt");
        boolean areEqual = true;
        int lineCounter = 1;


        try (BufferedReader reader1 = Files.newBufferedReader(path1);
             BufferedReader reader2 = Files.newBufferedReader(path2)) {

            String line1 = reader1.readLine();
            String line2 = reader2.readLine();

            while (line1 != null || line2 != null) {

                if (line1 == null) {
                    areEqual = false;
                    Printer.print(finalPath, "null", line2, lineCounter);

                } else if (line2 == null) {
                    areEqual = false;
                    Printer.print(finalPath, line1, "null", lineCounter);

                } else if (!line1.equals(line2)) {
                    areEqual = false;
                    Printer.print(finalPath, line1, line2, lineCounter);
                }
                
                line1 = reader1.readLine();
                line2 = reader2.readLine();
                lineCounter++;
            }
            if (areEqual) {
                Files.writeString(Path.of("finalpath.txt"), "file 1 and file 2 are equal", StandardOpenOption.CREATE);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}