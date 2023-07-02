public class Solution286 {

    // 核心：异或运算满足交换律，只要所有的索引和对应的数字异或（已经添加了最后一位数字），最后落单的就是题目所需
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        res ^= n;
        for (int i = 0; i < n; i++) {
            res ^= (i ^ nums[i]);
        }
        return res;
    }
}
