package IT_Step_Homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountLinesWithLetters {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("file_I.txt"));
            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                int letterICount = countLettersInLine(line, 'И');
                int letteriCount = countLettersInLine(line, 'и');

                if (letterICount >= 5 || letteriCount >= 5) {
                    System.out.println(line);
                    count++;
                }
            }

            System.out.println("Total number of lines with 5 or more 'И' or 'и': " + count);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countLettersInLine(String line, char letter) {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == letter) {
                count++;
            }
        }
        return count;
    }
}
