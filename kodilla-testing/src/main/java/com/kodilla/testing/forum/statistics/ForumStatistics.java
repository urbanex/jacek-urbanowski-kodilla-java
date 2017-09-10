package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    int usersQuantity = 0;
    int postsQuantity = 0;
    int commentsQuantity = 0;
    Double postsPerUser = null;
    Double commentsPerUser = null;
    Double commentsPerPost = null;

    public void calculateAdvStatistics(Statistics statistics) {
        usersQuantity = statistics.usersNames().size();
        postsQuantity = statistics.postsCount();
        commentsQuantity = statistics.commentsCount();

        if (usersQuantity > 0) {
            postsPerUser = (double) postsQuantity / usersQuantity;
            commentsPerUser = (double) commentsQuantity / usersQuantity;
        }

        if (postsQuantity > 0) {
            commentsPerPost = (double) commentsQuantity / postsQuantity;
        }
    }

    public void ShowStatistics() {
        System.out.println("Number of users: " + usersQuantity + "/nNumber of posts: " + postsQuantity +
                "/nNumber of comments: " + commentsQuantity + "/nNumber of posts per user: " + postsPerUser +
                "/nNumber of comments per user: " + commentsPerUser + "/nNumber of comments per post: " + commentsPerPost);
    }

}
