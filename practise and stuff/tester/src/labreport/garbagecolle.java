package labreport;

public class garbagecolle {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Garbage Collected");
    }

    public static void main(String[] args) {
        garbagecolle g1 = new garbagecolle();
        garbagecolle g2 = new garbagecolle();
        g1=g2=null;
        System.gc();

    }
}
