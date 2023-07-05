import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> cur = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String cursubstring = s.substring(i, i + 10);
            if (cur.contains(cursubstring)) {
                res.add(cursubstring);
            } else {
                cur.add(cursubstring);
            }
        }
        return new LinkedList<>(res);
    }
}
