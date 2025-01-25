package labreport;

import java.util.Scanner;

public class Student {
        int rollno;
        String name;
        String address;
        String phno;
        String emailid;
        Student(int a , String b , String c, String d, String e){
            this.rollno=a;
            this.name=b;
            this.address =c;
            this.phno=d;
            this.emailid=e;
        }
        public static void main(String[] args) {
         Student[] array = new Student[1];
         Student a = new Student(24117,"Ram","123 road","1234567890","example@hostname.com");
         array[0]=a;
            for (Student z :array){
                System.out.print(z.name+" "+z.rollno+" "+z.address+" "+z.phno+" "+z.emailid);
            }
        }
    }

