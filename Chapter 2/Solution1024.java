import java.util.Arrays;

public class Solution1024 {
    //区间调度问题再加最值问题，所以使用贪心算法，排序规则是按照开始时间进行一个升序排列，如果开始时间相同再按照结束时间降序排列，
    //因为我们开始时间相同的话，我们肯定优先选择长的那个片段，这样需要的数量就会少点
    public int videoStitching(int[][] clips, int time) {
        if (clips.length == 0) {
            return 0;
        }
        //  按照start升序排序，start相同时，按照end降序排序
        Arrays.sort(clips, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int i = 0, n = clips.length, res = 0, curEnd = 0, nextEnd = 0;

        //这里的处理太巧妙了
        //其实我们的循环条件是从排序后的第一个片段开始遍历，一直找到视频片段开始时间大于当前结束时间的片段就结束
        while (i < n && clips[i][0] <= curEnd) {
            while (i < n && clips[i][0] <= curEnd) {
                //下一次的结束时间就是开始时间小于等于当前结束时间的片段中，结束时间最晚的那个
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }
            res++;
            curEnd = nextEnd;
            if (curEnd >= time) {
                return res;
            }
        }
        return -1;
    }
}
