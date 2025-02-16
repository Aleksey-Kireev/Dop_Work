package DZ_Dop1;

import java.util.Arrays;
import java.util.Scanner;

public class DZ_Dop1 {
    public static void main(String[] args) {
        System.out.println(" \n Работа с новым пакетом и классом \n ");

        // --------------- ********************** ---------------------------

        genArray_DZ_3();            //  Вызов выполнение задания № 3

        // --------------- ********************** ---------------------------

        genArray_max();            //  Вызов выполнение задания № 4

        // --------------- ********************** ---------------------------

        arrayIndex();            //  Вызов выполнение задания № 5


    }

    public static void arrayIndex() {

        //       Задание № 4   Сгенерировать массив [x,y] в диапазоне [m,n] и вывести этот массив и дополнительно
        //       вывести идекс строки с наибольшим произведением
        int[] inputArray = inputParam();           //      Запрос параметров массива
        System.out.println("\n Вывод min, max, str, stolb \n " + Arrays.toString(inputArray));
        int min = inputArray[0];
        int max = inputArray[1];
        int str = inputArray[2];
        int stolb = inputArray[3];
        int[][] array = generationArr(min, max, str, stolb);        // Заполнение массива рандомными числами
        System.out.println("\n Сгенерированный массив ");
        for (int[] i : array) {
            System.out.println(Arrays.toString(i));         // Вывод этого массива
            System.out.println();
        }
        int[] arrayIndexMore = new int[str];
        int index = 0;
        for (int[] i : array) {
            int result = 1;
            for (int j : i) {
                result *= j;
            }
            arrayIndexMore[index] = result;
            index++;
        }
        System.out.println("Вывод произведений строк ");
        System.out.println("\n" + Arrays.toString(arrayIndexMore));
        int more = Integer.MIN_VALUE;
        index = 0;
        for (int i = 0; i < arrayIndexMore.length; i++) {
            if (arrayIndexMore[i] > more) {
                more = arrayIndexMore[i];
                index = i;
            }
        }
        System.out.printf("Наибольшее число в массиве - " + more + "\n     под индексом - " + index);


    }

    // --------------- ********************** ---------------------------

    public static void genArray_max() {

        //        Задание № 4   Сгенерировать массив [x,y] в диапазоне [m,n] и вывести этот массив и дополнительно
        //        вывести MAX элемент

        int[] inputArray = inputParam();           //      Запрос параметров массива
        System.out.println("\n Вывод min, max, str, stolb \n " + Arrays.toString(inputArray));
        int min = inputArray[0];
        int max = inputArray[1];
        int str = inputArray[2];
        int stolb = inputArray[3];
        int[][] array = generationArr(min, max, str, stolb);
        System.out.println("\n Сгенерированный массив ");
        for (int[] i : array) {
            System.out.println(Arrays.toString(i));
            System.out.println();
        }
        int more = min;
        for (int[] i : array) {
            for (int j : i) {
                if (j > more) more = j;
            }
        }
        System.out.println("Наибольшее число в массиве - " + more);

    }


    public static void genArray_DZ_3() {

//        Задание № 3   Сгенерировать массив [x,y] в диапазоне [m,n] и вывести этот массив

        System.out.println();
        Scanner inNum;         //  Инициализируем сканер
        inNum = new Scanner(System.in);          //  Ввод числа
        System.out.print("Введите минимальное число от -99 до 99 : ");
        int min = inNum.nextInt();
        System.out.print("Введите максимальное число от -99 до 99 : ");
        int max = inNum.nextInt();
        if (min >= max) {
            throw new IllegalArgumentException();
        }

        System.out.print("Введите число строк от 1 до 30 : ");
        int str = inNum.nextInt();
        System.out.print("Введите число столбцов от 1 до 30 : ");
        int stolb = inNum.nextInt();
        int[][] array;
        if (str > 30 && str < 1 && stolb > 30 && stolb < 1) {
            throw new IllegalArgumentException();
        } else {
            array = generationArr(min, max, str, stolb);
        }

        for (int[] i : array) {

            System.out.println(Arrays.toString(i));
            System.out.println();
        }

        // --------------- ********************** ---------------------------

    }

    // --------------- ********************** ---------------------------

    public static int[] inputParam() {
        System.out.println();
        Scanner inNum;         //  Инициализируем сканер
        inNum = new Scanner(System.in);          //  Ввод числа
        System.out.print("Введите минимальное число от -99 до 99 : ");
        int min = inNum.nextInt();
        System.out.print("Введите максимальное число от -99 до 99 : ");
        int max = inNum.nextInt();
        if (min >= max) {
            throw new IllegalArgumentException();
        }

        System.out.print("Введите число строк от 1 до 30 : ");
        int str = inNum.nextInt();
        System.out.print("Введите число столбцов от 1 до 30 : ");
        int stolb = inNum.nextInt();
        if (str > 30 && str < 1 && stolb > 30 && stolb < 1) {
            throw new IllegalArgumentException();
        } else {
            return new int[]{min, max, str, stolb};
        }
    }

    public static int[][] generationArr(int min, int max, int str, int stolb) {
        if (min > max) {
            throw new IllegalArgumentException();
        } else {
            int[][] arr = new int[str][stolb];
            int diff = max - min;
            for (int i = 0; i < str; i++) {
                for (int j = 0; j < stolb; j++) {
                    float randomFloat = (float) (Math.random() * diff + min);
                    arr[i][j] = (int) randomFloat;
                }
            }

            return arr;
        }

    }

    // --------------- ********************** ---------------------------


}





