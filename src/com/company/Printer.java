package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Printer {

    public static void print(Path path, String firstLine, String secondLine, int lineNumber) throws IOException {

        String content;
        int length1 = firstLine.length();
        int length2 = secondLine.length();
        int bigger = Math.max(length1, length2);
        char firstLineChar = ' ';
        char secondLineChar = ' ';


        if (firstLine.equals("null")) {
            content = "Difference in line " + lineNumber + ", file 1 it's null, and file 2 says: '" + secondLine + "'";
            Files.writeString(path, content + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
        else if (secondLine.equals("null")) {
            content = "Difference in line " + lineNumber + ", file 1 says: " + firstLine + " and file 2 it's null";
            Files.writeString(path, content + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
        else {
            for (int i = 0; i < bigger; i++) {
                if(i < firstLine.length()) firstLineChar = firstLine.charAt(i);
                if(i < secondLine.length()) secondLineChar = secondLine.charAt(i);

                if (!(firstLineChar == secondLineChar)) {
                    content = "Difference in line n°: " + lineNumber + ", char n°: " + i + ". File 1 char: '"
                            + firstLineChar + "'. File 2 char: '" + secondLineChar + "'";
                    Files.writeString(path, content + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                }
                firstLineChar = ' ';
                secondLineChar = ' ';
            }
        }
    }
}
