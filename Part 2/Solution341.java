import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution341 {
    public class NestedIterator implements Iterator<Integer> {
        // 实现NestedInteger 类
        public class NestedInteger {
            private Integer val;
            private List<NestedInteger> list; // 为什么list里面是NestedInteger类型，因为这里可以无限嵌套

            public NestedInteger(Integer val) {
                this.val = val;
                this.list = null;
            }

            public NestedInteger(List<NestedInteger> list) {
                this.list = list;
                this.val = null;
            }

            // 如果其中存的是一个整数，则返回 true，否则返回 false
            public boolean isInteger() {
                return val != null;
            }

            // 如果其中存的是一个整数，则返回这个整数，否则返回 null
            public Integer getInteger() {
                return this.val;
            }

            // 如果其中存的是一个列表，则返回这个列表，否则返回 null
            public List<NestedInteger> getList() {
                return this.list;
            }

        }

        private Iterator<Integer> it;
        public NestedIterator(List<NestedInteger> nestedList) {
            List<Integer> res = new LinkedList<>();
            for (NestedInteger i : nestedList) {
                traverse(i, res);
            }
            // 得到 res 列表的迭代器
            this.it = res.iterator();
        }

        // 类似N叉树的遍历
        private void traverse(NestedInteger root, List<Integer> res) {
            if (root.isInteger()) {
                res.add(root.getInteger());
                return;
            } else {
                for (NestedInteger child : root.getList()) {
                    traverse(child, res);
                }
            }
        }

        @Override
        public Integer next() {
            return it.next();
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }
    }
}
