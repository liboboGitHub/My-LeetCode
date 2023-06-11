import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Solution380 {
    List<Integer> list;
    HashMap<Integer, Integer> valToindex;
    Random random;

    public Solution380() {
        list = new ArrayList<>();
        valToindex = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (valToindex.containsKey(val)) {
            return false;
        }
        list.add(val);
        valToindex.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!valToindex.containsKey(val)) {
            return false;
        }
        // 瞒天过海，借刀杀人
        int index = valToindex.get(val);
        int listLast = list.get(list.size() - 1);
        list.set(index, listLast);
        list.remove(list.size() - 1);
        valToindex.put(listLast, index);
        valToindex.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
