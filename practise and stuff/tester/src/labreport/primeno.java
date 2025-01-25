package labreport;

import java.util.HashSet;
import java.util.Set;

public class primeno {
    public static void firsthundredprimeno() {
        Set<Integer> set = new HashSet<>();
        int i = 1;
        int k = 1;
        System.out.print(k + " ");
        while (k != 100) {
            k++;
            boolean m = false;
            for (int j : set) {
                if (k % j == 0) {
                    m = true;
                    break;
                }
            }
            if (m) {
                continue;
            }
            set.add(k);
            System.out.print(k + " ");
            i++;

        }
    }

    public static void main(String[] args) {
        firsthundredprimeno();
    }
}

