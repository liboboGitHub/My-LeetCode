import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        long s1 = System.currentTimeMillis();
        int[][] arr = new int[10000][10000];
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                arr[j][i] = 1;
            }
        }
        long s2 = System.currentTimeMillis();
        System.out.println(s2 - s1);
        List<Integer> key = Arrays.asList(12, 13, 14);
        System.out.println(key);
    }
}
