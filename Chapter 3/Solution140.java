import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution140 {

    List<String> res = new LinkedList<>();
    LinkedList<String> trace = new LinkedList<>();
    List<String> wordDict;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        backtrace(s, 0);
        return res;
    }

    private void backtrace(String s, int i) {

        // base case,符合条件
        if (i == s.length()) {
            res.add(String.join(" ", trace));
            return;
        }

        // 标准回溯
        for (String word : wordDict) {
            int len = word.length();
            // 当前单词符合S的前缀
            if (i + len <= s.length() && s.substring(i, i + len).equals(word)) {
                trace.addLast(word);
                // 继续匹配下一个前缀
                backtrace(s, i + len);
                // 回溯，撤销选择
                trace.removeLast();
            }
        }
    }
}
