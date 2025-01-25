package labreport;

import java.util.*;
public class Calculator {
  public static void main(String[] args)
 {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the first number =");
        int x = sc.nextInt();
        System.out.println("enter the second number =");
        int y = sc.nextInt();
        Scanner op = new Scanner(System.in);
        System.out.println("enter the operation you want to perform");
        char operation = op.next().charAt(0);

        double result;
        switch (operation) 
      {
            case '+':
                result = x + y;
                System.out.println(x + " + " + y + " = " + result);
                break;

            case '-':
                result = x - y;
                System.out.println(x + " - " + y + " = " + result);
                break;

            case '*':
                result = x * y;
                System.out.println(x + " * " + y + " = " + result);
                break;

            case '/':
                result = x / y;
                System.out.println(x + " / " + y + " = " + result);
                break;

            default:
                System.out.println("Invalid operator!");
                break;
        }
    }
}