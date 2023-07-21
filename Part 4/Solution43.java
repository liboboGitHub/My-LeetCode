public class Solution43 {
    public String multiply(String num1, String num2) {
        // 模拟手算的过程
        int n1 = num1.length(), n2 = num2.length();
        int[] res = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int part1 = num1.charAt(i) - '0', part2 = num2.charAt(j) - '0';
                // 相乘
                int mul = part1 * part2;
                // 部分和
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + res[p2];
                // 更新新位置
                res[p2] = sum % 10;
                res[p1] += sum / 10; // 注意为什么要 +
            }
        }
        // 去除前面多余的 0
        int start = 0;
        while (start < res.length && res[start] == 0) {
            ++start;
        }
        // 变成字符串
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < res.length; i++) {
            sb.append(res[i]);
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }
}
