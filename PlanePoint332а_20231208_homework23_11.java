package IT_Step_Homework;

import java.util.Scanner;

import static java.lang.System.in;

public class PlanePoint332а {
    public static void main(String[] args) {
        //Еxamination scan = new Еxamination (System.in);
        Scanner number = new Scanner (in);
        //int x = scan.nextInt ();
        //int y = scan.nextInt ();
        System.out.println("Задана плоскость с границей: " +
                "\nпо оси <Y> от 1 и выше; " +
                "\nпо оси <X> от |-2| и левее." +
                "\nВведите число: \nкоординату <Х> для точки-  ");
        int x = (int) number.nextFloat();
        System.out.println("координату <Y> для точки: ");
        float y = number.nextFloat();
        if (y >= 1 && x <= -2) {
            System.out.println ("Точка с координатами (" + x + ";" + y +
                    ") НАХОДИТСЯ в заданной плоскости");
        }
        else {
            System.out.println ("Точка с координатами (" + x + ";" + y +
                    ") НЕ НАХОДИТСЯ в заданной плоскости");
        }

    }
}
