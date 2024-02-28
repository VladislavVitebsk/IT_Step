package IT_Step_Homework;

import java.io.FileWriter;
import java.io.IOException;

public class NewTextFile {
    public static void main(String[] args) {
        String text = "Тараканы танк толкали,\n" +
                "Но столкнуть танк не смогли.\n" +
                "Тараканы так устали,\n" +
                "Что без сил в тени легли.";
        //файл "text.txt" создаем в той же директории, где находится файл с исходным кодом
        try {
            FileWriter writer = new FileWriter("text.txt");
            writer.write(text);
            writer.close();
            System.out.println("Текстовый файл успешно создан.");
        } catch (IOException e) {
            System.err.println("Ошибка при создании файла: " + e.getMessage());
        }
    }
}
