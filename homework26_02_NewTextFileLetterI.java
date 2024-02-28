package IT_Step_Homework;

import java.io.FileWriter;
import java.io.IOException;

public class NewTextFileLetterI {
    public static void main(String[] args) {
        String text = "Игрушечный ослик по имени Пит\n" +
                "Играть не идёт. «Извини, — говорит, —\n" +
                "Мне истины той не постигнуть никак:\n" +
                "Кто всё-таки — ослик я или ишак?";
        //файл "text.txt" создаем в той же директории, где находится файл с исходным кодом
        try {
            FileWriter writer = new FileWriter("text_I.txt");
            writer.write(text);
            writer.close();
            System.out.println("Текстовый файл успешно создан.");
        } catch (IOException e) {
            System.err.println("Ошибка при создании файла: " + e.getMessage());
        }
    }
}
