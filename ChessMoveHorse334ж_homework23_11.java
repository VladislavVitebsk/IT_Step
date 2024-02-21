package IT_Step_Homework;

import javax.swing.*;
import java.util.Scanner;

public class ChessMoveHorse {
    public static void main(String[] args) {
        System.out.println("На шахматной доске разместите шахматную фигуру \"Конь\"." +
                        "\nДля этого выполните нижеуказанные действия:");
        Scanner stand = new Scanner(System.in);
        System.out.println("Введите текущую координату фигуры по вертикали: ");
            byte cellStartVertical = stand.nextByte();
        System.out.println("Введите текущую координату фигуры по горизонтали: ");
            byte cellStartHorizontal = stand.nextByte();
        // Проверка координат
        if(cellStartVertical > 8 || cellStartVertical < 1 || cellStartHorizontal > 8 || cellStartHorizontal < 1)
        {
            System.out.print("ОШИБКА! \nВведеные координаты должны быть в диапазоне от 1 до 8 " +
                    "\nПопробуйте еще раз.");
            System.exit(0);

        }
        if(is_in_one_king_step(cellStartVertical,cellStartHorizontal))
            System.out.print("Фигура может сделать ход");
        else
            System.out.print("Фигура НЕ может сделать ход");
    }

    public static boolean is_in_one_king_step(byte cellStartVertical, byte cellStartHorizontal)
    {
        System.out.println("Укажите координаты клетки для хода фигуры, " +
                "\nдля этого выполните нижеуказанные действия:");
        Scanner move = new Scanner(System.in);
        System.out.println("Введите координату клетки хода по вертикали: ");
            byte moveToVertikal = move.nextByte(); // Вертикальная координата 2ой клетки
        System.out.println("Введите координату клетки хода по горизонтали: ");
            byte moveToHorizontal = move.nextByte(); // Горизонтальная координата 2ой клетки
        // Если исходная клетка = требуемой - возвращаем false
        if( cellStartVertical == moveToVertikal && cellStartHorizontal == moveToHorizontal )
            return false;
        // Сравнение разности по модулю - доступности такого хода
        //(abs(abs(a-c)-2)<0.5) and (abs(abs(b-d)-1)<0.5) or (abs(abs(a-c)-1)<0.5) and (abs(abs(b-d)-2.0)<0.5)
        return (Math.abs(Math.abs(cellStartVertical-moveToVertikal) - 2) < 0.5) &&
                (Math.abs(Math.abs(cellStartHorizontal-moveToHorizontal) - 1) < 0.5) ||
                (Math.abs(Math.abs(cellStartVertical-moveToVertikal) - 1) < 0.5) &&
                        (Math.abs(Math.abs(cellStartHorizontal-moveToHorizontal) - 2.0) < 0.5);

    }
}
