package labreport;

import java.util.SortedMap;

class Engine{
    int cc;
    String fueltype;
    Engine(int a,String b){
        this.cc=a;
        this.fueltype=b;
    }
}
class Car extends Engine{
    int yearofmfg;
    Car(int a,int b,String c){
        super(b,c);
        this.yearofmfg=a;
    }

}
class bike extends Engine{
    int model;
    bike(int a,int b,String c){
        super(b,c);
        this.model=a;
    }
}
class Truck extends Car{
    String model;
    Truck(String a,int b,int c,String d ){
        super(b,c,d);
        this.model=a;
    }
}
public class inheritanceexample {
    public static void main(String[] args) {
        Truck chotahathi = new Truck("sumo",2024,12000,"deisel");
        System.out.println(chotahathi.model+" Model of Truck");
        System.out.println("it was made in "+chotahathi.yearofmfg);
        System.out.println(chotahathi.cc+" It has this many cc");
        System.out.println(chotahathi.fueltype+" it uses this fuel");
    }
}
