package Work_1;// Работа с доп. заданиями.

import java.util.Scanner; // импорт сканера

//      Задание № 1

public class Work_1 {
    public static void main(String[] args) {
        System.out.print("Введите первое целое число от 1 до 100: ");
        Scanner scan = new Scanner(System.in);
        int number_1 = scan.nextInt();

        System.out.print("Введите второе целое число от 1 до 100: ");
        scan = new Scanner(System.in);
        int number_2 = scan.nextInt();
        int number_3 = number_1 / number_2;
        int number_4 = number_1 % number_2;

        System.out.println(number_1 + " разделить (/) на " + number_2 + " = " + number_3 + " и остаток " + number_4);
    }
}