import java.util.*;

public class Twitter {
    private static int timestamp = 0;

    private static class Tweet {
        private int id;
        private int time;
        private Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }

    private static class User {
        private int id;
        private Set<Integer> followed;
        // 用户发表的推文链表头结点
        private Tweet head;

        public User(int userId) {
            followed = new HashSet<>();
            this.id = userId;
            this.head = null;
            follow(id);
        }

        public void follow(int userId) {
            followed.add(userId);
        }

        public void unfollow(int userId) {
            if (userId != this.id) {
                followed.remove(userId);
            }
        }

        public void post(int tweetId) {
            Tweet twt = new Tweet(tweetId, timestamp);
            timestamp++;
            // 头插法
            twt.next = head;
            head = twt;
        }

    }

    private HashMap<Integer, User> userMap = new HashMap<>();

    /**
     * user 发表一条 tweet 动态
     */
    public void postTweet(int userId, int tweetId) {
        // 如果UserId 不存在则新建
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).post(tweetId);
    }

    /**
     * 返回该 user 关注的人（包括他自己）最近的动态 id
     * 合并K个有序链表
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return res;
        }
        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));

        for (int id : users) {
            Tweet t = userMap.get(id).head;
            if (t == null) {
                continue;
            }
            pq.add(t);
        }
        while (!pq.isEmpty()) {
            if (res.size() == 10) {
                break;
            }
            Tweet t = pq.poll();
            res.add(t.id);
            if (t.next != null) {
                pq.add(t.next);
            }
        }
        return res;
    }

    /**
     * follower 关注 followee
     */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followeeId)) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}
