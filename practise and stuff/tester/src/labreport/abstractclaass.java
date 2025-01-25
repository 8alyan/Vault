package labreport;

public class abstractclaass extends test{
    @Override
    public int sum(int a, int b) {
        return (a+b)*10;
    }

    public static void main(String[] args) {
        abstractclaass a = new abstractclaass();
        System.out.println(a.sum(2,3));
        System.out.println(a.sum(2,3,0));
    }
}
class test2 extends test{
    @Override
    public int sum(int a, int b) {
        return Math.abs(a-b);
    }
}
abstract class test{
    int a ;
    int b ;
    abstract public int sum(int a ,int b);
    public int sum(int a,int b,int c){
        return a+b+c;
    }
}
