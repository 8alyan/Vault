package leetcodeproblrms;

public class twofoureightfive {
    public int pivotInteger(int n) {
        int left = 1;
        int right = n;
        while (right > left) {
            int mid = left + (right - left) / 2;
            int normal = nrml(mid);
            int ranged = range(mid, n);
            if (normal == ranged) {
                return mid;
            }
            if (normal > ranged) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    public int nrml(int n) {
        return n * (n + 1) / 2;
    }

    public int range(int n, int k) {
        return (k * (k + 1) / 2 - n * (n + 1) / 2) + n;
    }

    public static void main(String[] args) {
        twofoureightfive g = new twofoureightfive();
        System.out.println(g.pivotInteger(4));
    }
}
