import java.util.ArrayList;
import java.util.List;

public class Solution151 {
    public String reverseWords(String s) {
        if (s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(s.trim());
        sb.reverse();
        String S = String.valueOf(sb);
        String[] temp = S.split(" ");
        List<String> l = new ArrayList<>();
        for (String ss : temp) {
            if (ss.length() != 0) {
                l.add(ss);
            }
        }
        StringBuilder[] sbArray = new StringBuilder[l.size()];
        for (int i = 0; i < l.size(); i++) {
            sbArray[i] = new StringBuilder(l.get(i));
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sbArray.length; i++) {
            StringBuilder subSB = sbArray[i].reverse();
            if (i != 0) {
                res.append(" ");
                res.append(subSB);
            } else {
                res.append(subSB);
            }
        }
        return String.valueOf(res);
    }
}
