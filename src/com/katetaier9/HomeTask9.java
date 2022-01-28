package com.katetaier9;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class HomeTask9 {
    public static final double INTEREST_RATE = 1.5;
    public static final int MONTHS_IN_THE_YEAR = 12;

    public static void main(String[] args) {

        /*В банк положили s денег. Какой станет сумма вклада через n лет, если процент 1,5% добавляется к сумме вклада
         ежемесячно(сложный процент). Написать метод который принимает 2 параметра - s, n и возвращает сумму денег
         на счету.*/
        inputOutput();

        /*Реализовать метод который вернет строку String, в которой через пробел все числа от 1 до 99 со следующими изменениями:
        (!!!Сам метод не должен ничего печатать в консоль, он просто должен вернуть строку!!!)
        - если число кратно 3 то вывести вместо него Hello
        - если число кратно 5 то вывести вместо него World
        - если число кратно и 3 и 5 то вывести вместо него HelloWorld
        - иначе вывести просто само число */
        System.out.print(getPhrases() + "\n\n");

        /*Написать метод который ищет при помощи бинарного поиска есть ли число в отсортированном массиве.
          Входящие параметры: массив и число.
         (считаем что массив который нам передали отсортирован, проверять это не нужно)*/
        superBinarySearch();

    }

    private static void superBinarySearch() {
        int[] arrayNumbers = new int[100];
        System.out.print("Please input the integer number: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(number);
        System.out.println(numberIsPresent(arrayNumbers, number));
    }

    private static String numberIsPresent(int[] arrayNumbers, int number) {
        int index = Arrays.binarySearch(sortedArray(arrayNumbers), number);
        if (index <= -arrayNumbers.length - 1 || index < 0) {
            return "There is no such a number in the array.";
        } else {
            return "The number is in the array and its index is " + index + ".";
        }
    }

    private static int[] sortedArray(int[] arrayNumbers) {
        for (int i = 0; i < 100; i++) {
            arrayNumbers[i] = i + 1;
        }
        return arrayNumbers;
    }

    private static void inputOutput() {
        System.out.print("Please enter the amount of your deposit: ");
        DecimalFormat df = new DecimalFormat("#.###");
        Scanner sc = new Scanner(System.in);
        double sumOfMoney = sc.nextDouble();
        System.out.println(sumOfMoney);
        System.out.print("Please enter the number of years: ");
        int years = sc.nextInt();
        System.out.println(years + ".");
        System.out.print("The final sum of money in " + years + " years will equal ");
        System.out.print(df.format(wealth(sumOfMoney, years)) + ".\n\n");
    }

    private static double wealth(double sumOfMoney, int years) {
        return sumOfMoney * Math.pow((1.0 + (INTEREST_RATE / 100)), (years * MONTHS_IN_THE_YEAR));
    }

    public static String getPhrases() {
        StringBuilder finalResult = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                finalResult.append("HelloWorld ");
            } else if (i % 3 == 0) {
                finalResult.append("Hello ");
            } else if (i % 5 == 0) {
                finalResult.append("World ");
            } else {
                finalResult.append(i).append(" ");

            }
        }
        return finalResult.toString().trim();
    }
}