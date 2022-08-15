package lesson3;

import java.util.Scanner;

/**
 * Постройте частотный словарь букв русского (или английского) алфавита.
 * Т.е. Сколько раз каждая бука алфавита повторяется во введенной строке.
 */
public class task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        char[] charArrayFromString = in.nextLine().toCharArray();

        int[] resultLowerCase = getFrequencyDictionaryOfLetters(charArrayFromString, 'a', 'z');
        int[] resultUpperCase = getFrequencyDictionaryOfLetters(charArrayFromString, 'A', 'Z');

        int[] resultFrequency = getFrequencyForLowerAndUpperCaseLetters(resultLowerCase, resultUpperCase);
        printFrequencyDictionary(resultFrequency);
    }

    public static int[] getFrequencyDictionaryOfLetters(char[] charArray, char firstLetter, char lastLetter) {
        int [] count = new int[lastLetter - firstLetter + 1];

        for (char singleCharElement : charArray) {
            if (singleCharElement >= firstLetter && singleCharElement <= lastLetter) {
                count[singleCharElement - firstLetter]++;
            }
        }

        return count;
    }

    public static int[] getFrequencyForLowerAndUpperCaseLetters(int[] lowerCaseFrequency, int[] upperCaseFrequency) {
        int[] frequency = new int['z' - 'a' + 1];

        for(int i = 0; i < lowerCaseFrequency.length; i++){
            frequency[i] = lowerCaseFrequency[i] + upperCaseFrequency[i];
        }

        return frequency;
    }

    public static void printFrequencyDictionary(int[] frequency) {
        for(int i = 0; i < frequency.length; i++){
            System.out.println((char) (i + 'a') + " → " + frequency[i]);
        }
    }
}
