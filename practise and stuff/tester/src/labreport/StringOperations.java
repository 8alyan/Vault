package labreport;

import java.util.Scanner;

public class StringOperations {
    public static int findLength(String str) {
        int length = 0;
        try {
            while (true) {
                char c = str.charAt(length);
                length++;
            }
        } catch (IndexOutOfBoundsException e) {
        }
        return length;
    }

    public static String concatenateStrings(String str1, String str2) {
        char[] result = new char[str1.length() + str2.length()];
        int i = 0;
        for (i = 0; i < str1.length(); i++) {
            result[i] = str1.charAt(i);
        }
        for (int j = 0; j < str2.length(); j++) {
            result[str1.length() + j] = str2.charAt(j);
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();
        int length = findLength(str1);
        System.out.println("Length of the first string: " + length);
        String concatenatedString = concatenateStrings(str1, str2);
        System.out.println("Concatenated string: " + concatenatedString);
        scanner.close();
    }
}