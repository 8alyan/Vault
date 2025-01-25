package labreport;
interface t1{
     int sd =8;
    static void call(){
         System.out.println("i m inside interface t1");
    }
     void called();
}
interface t2{
     static void call(){
        System.out.println("i m inside interface t2");
    }
}
class t3{
    public  void call(){
        System.out.println("i m inside class t3");
    }
}
public class interfaace extends t3 implements t1,t2 {
    public static void main(String[] args) {
        interfaace  t = new interfaace();
        System.out.println(sd);
        t.called();
        t1.call();
        t2.call();
    }

    @Override
    public void called() {
        System.out.println("called inside main class");
    }
}
