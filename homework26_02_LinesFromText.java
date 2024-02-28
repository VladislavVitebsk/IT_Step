package IT_Step_Homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LinesFromText {
    public static void main(String[] args) {
        String fileName = "file.txt";
        //Замените "file.txt" на путь к вашему текстовому файлу

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("T")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}
