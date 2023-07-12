import java.util.LinkedList;

public class Solution372 {
    public int superPow(int a, int[] b) {
        final int base = 1377;
        LinkedList<Integer> l = new LinkedList<>();
        for (int i : b) {
            l.add(i);
        }
        return superPow(a, l);

    }

    final int base = 1337;

    private int superPow(int a, LinkedList<Integer> l) {
        // 递归的base
        if (l.isEmpty()) {
            return 1;
        }
        int k = l.removeLast();
        int res = quickPow(a, k) * quickPow(superPow(a, l), 10);
        return res % base;
    }

    // (a*b)%k = (a%k)(b%k)%k
    // a^k = {k是奇数，= a^(k-1)*a；k是偶数， = a^(k/2)*a^(k/2)}
    private int quickPow(int a, int k) {
        if (k == 0) {
            return 1;
        }
        a = a % base;
        // k是奇数
        if (k % 2 == 1) {
            return (quickPow(a, k - 1) * a) % base;
        } else {
            return (quickPow(a, k / 2) * quickPow(a, k / 2) % base);
        }
    }
}
