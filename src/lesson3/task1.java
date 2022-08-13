package lesson3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Создать программу, которая позволяет ввести с клавиатуры массив размером n и отсортировать его по убыванию.
 */
public class task1 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);

        int n = makeMassiveUsingKeybord(in);
        int[] notSortedArray = new int[n];

        for(int i = 0; i < n; i++) {
            System.out.printf("Enter element %d: ", i);
            notSortedArray[i] = in.nextInt();
        }

        printMassive(notSortedArray);
        int[] sortedArray = sortMassiveByBubbleWay(Arrays.copyOf(notSortedArray, n));
        printSortedDescMassive(sortedArray);

        in.close();
    }

    public static int makeMassiveUsingKeybord(Scanner in) {
        System.out.print("Enter n: ");
        return in.nextInt();
    }

    public static void printMassive(int[] array) {
        System.out.println("Your base massive is:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if(i+1 < array.length) {
                System.out.print(", ");
            } else {
                System.out.println();
            }
        }
    }

    public static int[] sortMassiveByBubbleWay(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j=0; j < array.length-1;j++) {
                if(array[j]<array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        return array;
    }

    public static void printSortedDescMassive(int[] array) {
        System.out.println("Sorted massive DESC:\n" + Arrays.toString(array));
    }
}
