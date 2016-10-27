/**
 * 355. Design Twitter
 *
 * Design a simplified version of Twitter where users can post tweets,
 * follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed.
 * Your design should support the following methods:

 1. postTweet(userId, tweetId): Compose a new tweet.
 2. getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed.
 Each item in the news feed must be posted by users who the user followed or by the user herself.
 Tweets must be ordered from most recent to least recent.
 3. follow(followerId, followeeId): Follower follows a followee.
 4. unfollow(followerId, followeeId): Follower unfollows a followee.
 Example:

 Twitter twitter = new Twitter();

 // User 1 posts a new tweet (id = 5).
 twitter.postTweet(1, 5);

 // User 1's news feed should return a list with 1 tweet id -> [5].
 twitter.getNewsFeed(1);

 // User 1 follows user 2.
 twitter.follow(1, 2);

 // User 2 posts a new tweet (id = 6).
 twitter.postTweet(2, 6);

 // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 twitter.getNewsFeed(1);

 // User 1 unfollows user 2.
 twitter.unfollow(1, 2);

 // User 1's news feed should return a list with 1 tweet id -> [5],
 // since user 1 is no longer following user 2.
 twitter.getNewsFeed(1);
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {

    HashMap<Integer, Set<Integer>> followMap = new HashMap<Integer, Set<Integer>>();;
    HashMap<Integer, LinkedList<Tweet>> tweetMap = new HashMap<Integer, LinkedList<Tweet>>();
    int count = 0;

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!followMap.containsKey(userId)) followMap.put(userId, new HashSet<Integer>());
        followMap.get(userId).add(userId);
        if (!tweetMap.containsKey(userId)) tweetMap.put(userId, new LinkedList<Tweet>());
        tweetMap.get(userId).addFirst(new Tweet(count++, tweetId)); // tweets sorted
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<Integer>();
        if (!followMap.containsKey(userId)) return res;
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>(10000, new Comparator<Tweet>() {
            @Override
            public int compare(final Tweet t1, final Tweet t2) {
                return t2.ts - t1.ts;
            }
        });
        for (int followee : followMap.get(userId)) {
            if (!tweetMap.containsKey(followee) || tweetMap.get(followee).size()==0) continue;
            for (Tweet tweet : tweetMap.get(followee)) pq.add(tweet);
        }
        while (pq.size() > 0 && res.size() < 10) res.add(pq.poll().id);
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) followMap.put(followerId, new HashSet<Integer>());
        followMap.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId) && followeeId != followerId) followMap.get(followerId).remove(followeeId);
    }

    class Tweet {
        int ts;
        int id;
        public Tweet(int ts, int id) {
            this.ts = ts;
            this.id = id;
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
