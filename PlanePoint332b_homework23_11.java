package IT_Step_Homework;

import java.util.Scanner;

import static java.lang.System.in;

public class PlanePoint332b {
    public static void main(String[] args) {
        Scanner number = new Scanner(in);
        System.out.println("Задана плоскость с границей: " +
        "\nпо оси <Y> от |-2.0| до |+1.5|; " +
        "\nпо оси <X> от |0| до |-бесконечности| и |+бесконечности|." +
        "\nВведите число: \nкоординату <Х> для точки-  ");
        double x = number.nextDouble();
        System.out.println("координату <Y> для точки: ");
        double y = number.nextDouble();
        if (y >= -2 && y <= 1.5 && x >=0 || x <0) {
            System.out.println ("Точка с координатами (x/" + x + "/;y/" + y +
                    "/) НАХОДИТСЯ в заданной плоскости");
        }
        else {
            System.out.println ("Точка с координатами (x/" + x + "/;y/" + y +
                    "/) НЕ НАХОДИТСЯ в заданной плоскости");
        }
    }
}
