package ru.academits.yasudis.csv;

import java.io.*;

public class Csv {
    public static void convertCsvToHtml(String csvFileName, String htmlFileName) throws IOException {
        if (csvFileName == null) {
            throw new NullPointerException("Путь к CSV файлу равен null");
        }

        if (htmlFileName == null) {
            throw new NullPointerException("Путь к HTML файлу равен null");
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFileName));
             PrintWriter writer = new PrintWriter(htmlFileName)) {
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("\t<meta charset=\"utf-8\">");
            writer.println("\t<title>Таблица</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.print("<table border=\"2\" width=\"500\" align=\"center\">");

            final char cellSeparator = ',';
            final char quote = '"';
            final char less = '<';
            final char more = '>';
            final char amp = '&';

            boolean isQuotes = false;

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (!isQuotes) {
                    writer.println();
                    writer.println("\t<tr>");
                    writer.print("\t\t<td>");
                }

                int lineLength = line.length();

                for (int i = 0; i < lineLength; i++) {
                    char currentCharacter = line.charAt(i);

                    if (currentCharacter == quote) {
                        if (isQuotes && i + 1 < lineLength && line.charAt(i + 1) == quote) {
                            writer.print("\"");
                            i++;
                        } else {
                            isQuotes = !isQuotes;
                        }
                        continue;
                    }

                    if (currentCharacter == less) {
                        writer.print("&lt;");
                        continue;
                    }

                    if (currentCharacter == more) {
                        writer.print("&gt;");
                        continue;
                    }

                    if (currentCharacter == amp) {
                        writer.print("&amp;");
                        continue;
                    }

                    if (currentCharacter == cellSeparator && !isQuotes) {
                        writer.println("</td>");
                        writer.print("\t\t<td>");
                        continue;
                    }

                    writer.print(currentCharacter);
                }

                if (!isQuotes) {
                    writer.println("</td>");
                    writer.print("\t</tr>");
                    continue;
                }

                writer.print("<br/>");
            }

            writer.println();
            writer.println("</table>");
            writer.println("</body>");
            writer.print("</html>");
        }
    }
}