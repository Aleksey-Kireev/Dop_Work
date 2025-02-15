import java.util.Scanner;
import java.util.Arrays;

//   Дополнительные задания
public class Main {
    public static void main(String[] args) {
        System.out.println("Дополнительные задания.");

//        Задание № 1   Проверить является ли число простым

        int povtor = 1;         //  Задаем кол-во повторений
        Scanner inNum;         //  Инициализируем сканер
        inNum = new Scanner(System.in);          //  Ввод числа
        while (povtor <= 2) {         //  Цикл кол-ва повторений
            System.out.println(" ");
            System.out.print("Введите число от 0 до 100 : ");
            int n = inNum.nextInt();         //  Ввод числа для проверки
            int flag = 0;
            for (int k = 2; k <= Math.sqrt(n); k++) {         //  цикл проверки на простоту
                if (n % k == 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println("Число " + n + " простое");
            } else {
                System.out.println("Число " + n + " не простое");
            }
            povtor += 1;

        }

//        Задание № 2   Занести и вывести все простые числа до указанного

        System.out.println();
        System.out.println("Вывод всех простых чисел до указанного");
        System.out.print("Введите число от 1 до 100 : ");
        int n = inNum.nextInt();

        //          Формируем размер массива

        int tmp = n;
        int bSize = 0;

        for (int j = 0; j < n; j += 10) {
            if (tmp > 10) {
                tmp -= 10;
            }
            bSize += 1;
        }

        System.out.println(" Размер - " + bSize + " x 10");    //      Выводим размер массива
        String[][] array = new String[bSize][10];     //      Инициализируем массив
        int flag;           //      Далее идет проверка и заполнение массива
        tmp = 1;
        for (int i = 0; i < bSize; i++) {
            for (int j = 0; j < 10; j++) {
                if (tmp <= n) {
                    flag = 1;
                    for (int k = 2; k <= Math.sqrt(tmp); k++) {

                        if (tmp % k == 0) {
                            flag = 0;
                            break;
                        }

                    }
                    if (flag == 0) {
                        array[i][j] = "-";
                    } else {
                        array[i][j] = "" + tmp;
                    }
                    tmp += 1;
                }
            }
        }

        //      Вывод заполненного массива
        //   ---- Способ 1, через for

        System.out.println(" \n ---- Вывод способом № 1 ----");
        for ( int i = 0; i < bSize; i++){
            for (int j = 0; j < 10; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        //   ---- Способ 2, через Arrays.toString

        System.out.println("\n ---- Вывод способом № 2 ----");
        for (String[] i : array) {
//            for (int j = 0; j < 10; j++) {
            System.out.print(Arrays.toString(i).replaceAll(", ", " ").replaceAll("[\\[\\]]", " "));
            System.out.println();
        }


    }
}