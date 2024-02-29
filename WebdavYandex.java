package WebDAV;

import java.io.FileWriter;
import java.io.IOException;

public class WebdavYandex {
    public static void main(String[] args) {
        //WebDAV
        //qnsgjusftnxjkhga
        //Задаем имя файла
        String fileName = "z:/data.txt";
        FileWriter fw = null;
        try {
            fw = new FileWriter(fileName);
        } catch (IOException e) {
            System.out.printf("Не удалось создать файл \"%s\"", fileName);
        }
        if (fw==null) return;
        String s = "Строка для записи";
        try {
            fw.append(s);
            fw.close();
        } catch (IOException e) {
            System.out.printf("Не удалось записать в файл \"%s\"", fileName);
        }
    }
}
