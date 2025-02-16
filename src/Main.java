import DZ_Dop1.DZ_Dop1;

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
        for (int i = 0; i < bSize; i++) {
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

//        Задание № 3   Преобразование числа в строку с указанной системой исчисления

        int number = 72; // Исходное целое число
        int radix = 16; // Основание системы счисления (например, 16 для шестнадцатеричной)

        // Преобразование числа в строку в указанной системе счисления
        String numberString = Integer.toString(number, radix);

        System.out.println(" \n Число " + number + " в системе счисления с основанием " + radix + " равно: " + numberString);

//          Задание № 4   Создайте массив из 11 случайных чисел из промежутка [start;end].
//          Выведите данный массив в консоль. Напишите программу, которая определяет,
//          какой элемент встречается в массиве чаще всего. Выведите данную информацию
//          в консоль. Если два разных элемента встречаются одинаковое количество раз,
//          то выведите -1

        System.out.println();
        for (int i = 0; i < 5; i++) {           //      Задаем количество повторений кода
            task4();                            //      Вызываем метод выполнения задания 4
        }

        DZ_Dop1.main(args);


    }

    public static void task4() {
        int start = 1;                       //      Задаем нижнюю границу
        int end = 4;                        //      Задаем верхнюю границу
        int[] nums = generateRandomArray(start, end, 11);   //      Вызываем метод заполнения массива в указанных
        // границах
        System.out.println(Arrays.toString(nums));              //      выводим получившийся массив

//                Цикл подсчета количества одинаковых элементов в массиве
        int[] numCount = new int[end - start];
        for (int num : nums) {
            int index = num - start;
            numCount[index]++;
        }
        System.out.println();
        System.out.print(Arrays.toString(numCount));            //      Вывод количества в консоль
        System.out.println();

//                Определение популярного и второго по популярности элемента
        int mostPopularNum = 0;
        int secondMostPopularNum = 0;
        int max = numCount[0];
        for (int i = 0; i < numCount.length; i++) {
            int count = numCount[i];

            if (count >= max) {
                secondMostPopularNum = mostPopularNum;
                mostPopularNum = i + start;
                max = count;
                continue;
            }

            if (count > secondMostPopularNum) {
                secondMostPopularNum = i + start;
            }
        }

        int result = mostPopularNum;
        if (mostPopularNum == secondMostPopularNum) {
            result = -1;
        }
        System.out.println(result);
    }

    private static int[] generateRandomArray(int start, int end, int size) {
        if (start > end || size < 0) {
            throw new IllegalArgumentException();
        }

        int[] arr = new int[size];
        int diff = end - start;

        for (int i = 0; i < size; i++) {
            float randomDouble = (float) (Math.random() * diff + start);
            arr[i] = (int) randomDouble;
        }

        return arr;
    }

}