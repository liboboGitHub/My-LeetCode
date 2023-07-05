public class Solution1804 {
    TrieMap<Integer> trieMap = new TrieMap<>();

    // 插入 word 并记录插入次数
    public void insert(String word) {
        if (trieMap.containsKey(word)) {
            trieMap.put(word, 1);
        } else {
            trieMap.put(word, trieMap.get(word) + 1);
        }
    }

    // 查询 word 插入的次数
    public int countWordsEqualTo(String word) {
        if (!trieMap.containsKey(word)) {
            return 0;
        } else {
            return trieMap.get(word);
        }
    }

    // 累加前缀为 prefix 的键的插入次数总和
    public int countWordsStartingWith(String prefix) {
        int res = 0;
        for (String key : trieMap.keysWithPrefix(prefix)) {
            res += trieMap.get(key);
        }
        return res;
    }

    // word 的插入次数减一
    public void erase(String word) {
        int freq = trieMap.get(word);
        if (freq - 1 == 0) {
            trieMap.remove(word);
        } else {
            trieMap.put(word, freq - 1);
        }
    }

}
