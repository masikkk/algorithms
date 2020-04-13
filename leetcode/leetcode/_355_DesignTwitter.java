package leetcode.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * 设计推特
 * https://leetcode-cn.com/problems/design-twitter/
 * @author masikkk.com 2020-04-13 11:25
 */
public class _355_DesignTwitter {
    private static class Twitter {
        // 全局时间戳，每当用户发推时加1
        private int timestamp;
        // 用户 <-> 推文列表 map
        private Map<Integer, List<Tweet>> userIdToTweetListMap;
        // 用户 <-> 关注集合 map
        private Map<Integer, Set<Integer>> userIdToFollowSetMap;

        // 推文类
        class Tweet {
            int id;
            int time;
            Tweet(int id, int time) {
                this.id = id;
                this.time = time;
            }
        }

        public Twitter() {
            timestamp = 1;
            userIdToTweetListMap = new HashMap<>();
            userIdToFollowSetMap = new HashMap<>();
        }

        // 发推
        public void postTweet(int userId, int tweetId) {
            List<Tweet> tweetList = userIdToTweetListMap.computeIfAbsent(userId, k -> new LinkedList<>());
            tweetList.add(new Tweet(tweetId, timestamp++));
        }

        // 拉取用户能看到的最新10条推文
        public List<Integer> getNewsFeed(int userId) {
            // userIdSet 需要查询哪些用户的推文
            Set<Integer> userIdSet = new HashSet<>();
            userIdSet.add(userId);
            userIdSet.addAll(userIdToFollowSetMap.getOrDefault(userId, new HashSet<>()));
            // 查询推文
            List<Tweet> tweetList = new ArrayList<>();
            userIdSet.forEach(uid -> tweetList.addAll(userIdToTweetListMap.getOrDefault(uid, new ArrayList<>())));
            // 按 time 倒序排序
            tweetList.sort((tweet1, tweet2) -> tweet2.time - tweet1.time);
            return tweetList.stream().limit(10).map(tweet -> tweet.id).collect(Collectors.toList());
        }

        // 关注
        public void follow(int followerId, int followeeId) {
            if (followerId == followeeId) {
                // 自己不能关注自己
                return;
            }
            Set<Integer> followSet = userIdToFollowSetMap.computeIfAbsent(followerId, k -> new HashSet<>());
            followSet.add(followeeId);
        }

        // 取关
        public void unfollow(int followerId, int followeeId) {
            Set<Integer> followSet = userIdToFollowSetMap.get(followerId);
            if (null == followSet) {
                return;
            }
            followSet.remove(followeeId);
        }
    }

    @Test
    public void testTwitter() {
        Twitter twitter = new Twitter();
        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

        // User 1's news feed should return a list with 1 tweet id -> [5].
        System.out.println(twitter.getNewsFeed(1));

        // User 1 follows user 2.
        twitter.follow(1, 2);

        // User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        System.out.println(twitter.getNewsFeed(1));

        // User 1 unfollows user 2.
        twitter.unfollow(1, 2);

        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        System.out.println(twitter.getNewsFeed(1));
    }

    @Test
    public void testTwitter2() {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(2, 1);
        System.out.println(twitter.getNewsFeed(2));
        twitter.unfollow(2, 1);
        System.out.println(twitter.getNewsFeed(2));
    }

    @Test
    public void testTwitter3() {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.follow(1, 1);
        System.out.println(twitter.getNewsFeed(1));
    }
}