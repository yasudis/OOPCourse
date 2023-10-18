package ru.academits.yasudis.csv;

import java.io.*;
import java.util.Scanner;

public class CSV {
    public void convertCsvToHtml(String pathToCsv, String pathToHtml) throws FileNotFoundException {
        try (Scanner scanner = new Scanner((new FileReader(pathToCsv)));
             PrintWriter printWriter = new PrintWriter(pathToHtml)) {
            printWriter.println("<!DOCTYPE html>");
            printWriter.println("<html>");
            printWriter.println("<head>\n\t<meta charset=\"utf-8\">");
            printWriter.println("\t<title>Таблица</title></head>");
            printWriter.println("<body>");
            printWriter.print("<table border=\"2\" width=\"500\" align=\"center\">");

            final char cellSeparator = ',';
            final char quote = '"';
            final char less = '<';
            final char more = '>';
            final char amp = '&';

            boolean inQuotes = false;

            String line;

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();

                if (line.isEmpty()) {
                    continue;
                }

                if (!inQuotes) {
                    printWriter.print("\n\t<tr>\n\t\t<td>");
                }

                int lineLength = line.length();

                for (int i = 0; i < lineLength; i++) {
                    char currentCharacter = line.charAt(i);

                    if (currentCharacter == quote) {
                        if (inQuotes && i + 1 < lineLength && line.charAt(i + 1) == quote) {
                            printWriter.print("\"");
                            i++;
                        } else {
                            inQuotes = !inQuotes;
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

                    if (currentCharacter == cellSeparator && !inQuotes) {
                        printWriter.print("</td>\n\t\t<td>");
                        continue;
                    }

                    printWriter.print(currentCharacter);
                }

                if (!inQuotes) {
                    printWriter.print("</td>\n\t</tr>");
                    continue;
                }

                printWriter.print("<br/>");
            }

            printWriter.print("\n</table>\n</body>\n</html>");
        }
    }
}