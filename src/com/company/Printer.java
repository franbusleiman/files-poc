package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Printer {

    public static void print(Path path, String firstLine, String secondLine, int lineNumber) throws IOException {

        String content = "Difference in line " + lineNumber + ", file 1 says: '" + firstLine + "' and file 2 says: '" + secondLine + "'";

        if (firstLine.equals("null"))
            content = "Difference in line " + lineNumber + ", file 1 it's null, and file 2 says: '" + secondLine + "'";
        else if (secondLine.equals("null"))
            content = "Difference in line " + lineNumber + ", file 1 says: " + firstLine + " and file 2 it's null";

        Files.writeString(path, content + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}
