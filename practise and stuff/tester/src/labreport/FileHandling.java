package labreport;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.*;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("sahil.txt");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            fw.write(str.charAt(i));
        }
        System.out.println("Writing successful!");
        fw.close();
        FileReader fr = new FileReader("sahil.txt");
        int i;
        System.out.println("Reading from file:");
        while ((i = fr.read()) != -1) {
            System.out.print((char) i);
        }
        System.out.println("\nReading successful!");
        fr.close();
    }
}
