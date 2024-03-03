package IT_Step_Homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VeryLongLine {
    public static void main(String[] args) {
        
        String fileName = "text_I.txt"; // Имя файла
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int maxLength = 0;
            int lineNumber = 0;
            String longestLine = "";
            String line;
            int currentLineNumber = 0;

            while ((line = br.readLine()) != null) {
                currentLineNumber++;
                if (line.length() > maxLength) {
                    maxLength = line.length();
                    lineNumber = currentLineNumber;
                    longestLine = line;
                }
            }

            System.out.println("Длина самой длинной строки: " + maxLength);
            System.out.println("Номер самой длинной строки: " + lineNumber);
            System.out.println("Самая длинная строка: " + longestLine);

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
