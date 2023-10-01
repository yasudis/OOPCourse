package ru.academits.yasudis.csv;

import java.io.*;

public class CSV {
    public void convertCSVtoHTML(String readPath, String writePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(readPath));
             PrintWriter printWriter = new PrintWriter(writePath)) {
            printWriter.print("<!DOCTYPE html>");
            printWriter.print("<html>");
            printWriter.print("<head><meta charset=\"utf-8\"><title>Таблица</title></head>");
            printWriter.print("<body>");
            printWriter.print("<table border=\"2\" width=\"500\" align=\"center\">");

            char cellSeparator = ',';
            char quote = '"';
            char less = '<';
            char more = '>';
            char amp = '&';

            int quotesCount = 0;

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                int lineLength = line.length();

                if (lineLength == 0) {
                    continue;
                }

                if (quotesCount % 2 == 0) {
                    printWriter.print("<tr><td>");
                }

                for (int i = 0; i < lineLength; i++) {
                    char currentCharacter = line.charAt(i);

                    if (currentCharacter == quote) {
                        ++quotesCount;

                        if (quotesCount % 3 == 0) {
                            printWriter.print(quote);
                        }

                        continue;
                    }

                    if (currentCharacter == less) {
                        printWriter.print("&lt;");
                        continue;
                    }

                    if (currentCharacter == more) {
                        printWriter.print("&gt;");
                        continue;
                    }

                    if (currentCharacter == amp) {
                        printWriter.print("&amp;");
                        continue;
                    }

                    if (currentCharacter == cellSeparator && quotesCount % 2 == 0) {
                        printWriter.print("</td><td>");

                        quotesCount = 0;

                        continue;
                    }

                    printWriter.print(currentCharacter);
                }

                if (quotesCount % 2 == 0) {
                    printWriter.print("</td></tr>");

                    quotesCount = 0;

                    continue;
                }

                printWriter.print("<br/>");
            }

            printWriter.print("</table></body></html>");
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }
    }
}