package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {

    Statistics statisticsMock;
    ForumStatistics forumStatistics;
    List<String> users;

    @Before
    public void before() {
        //given
        statisticsMock = mock(Statistics.class);
        users = new ArrayList<>();
        users.add("batman");
        users.add("robin hood");
        users.add("superman");
        users.add("spiderman");
        forumStatistics = new ForumStatistics();

        //when
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(25);

    }

    @Test
    public void testCalculateAdvStatistics() {

        //when
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(4, forumStatistics.usersQuantity);
        Assert.assertEquals(10, forumStatistics.postsQuantity);
        Assert.assertEquals(25, forumStatistics.commentsQuantity);

    }

    @Test //gdy liczba postów = 0
    public void testCalculateWhen0Posts() {

        //when
        when(statisticsMock.postsCount()).thenReturn(0);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertNull(forumStatistics.commentsPerPost);

    }

    @Test //gdy liczba postów = 1000
    public void testCalculateWhen1000Posts() {

        //when
        when(statisticsMock.postsCount()).thenReturn(1000);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(new Double(250.0), forumStatistics.postsPerUser);
    }

    @Test //gdy liczba komentarzy = 0
    public void testCalculateWhen0Comments() {

        //when
        when(statisticsMock.commentsCount()).thenReturn(0);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(new Double(0), forumStatistics.commentsPerUser);
        Assert.assertEquals(new Double(0), forumStatistics.commentsPerPost);
        Assert.assertEquals(0, forumStatistics.commentsQuantity);
    }

    @Test //gdy liczba komentarzy < liczba postów
    public void testCalculateWhenCommentsLessThanPosts() {

        //when
        when(statisticsMock.commentsCount()).thenReturn(1);
        when(statisticsMock.postsCount()).thenReturn(2);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(new Double(0.5), forumStatistics.commentsPerPost);
    }

    @Test //gdy liczba komentarzy < liczba postów
    public void testCalculateWhenCommentsMoreThanPosts() {

        //when
        when(statisticsMock.commentsCount()).thenReturn(2);
        when(statisticsMock.postsCount()).thenReturn(1);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(new Double(2), forumStatistics.commentsPerPost);
    }

    @Test //gdy liczba userów = 0
    public void testCalculateWhen0Users() {

        //given
        users.clear();

        //when
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(0, forumStatistics.usersQuantity);
        Assert.assertNull(forumStatistics.postsPerUser);
        Assert.assertNull(forumStatistics.commentsPerUser);
    }

    @Test //gdy liczba userów = 100
    public void testCalculateWhen100Users() {

        //given
        for (int i = 1; users.size() < 100; i++) {
            users.add("username" + i++);
        }

        //when
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(100, forumStatistics.usersQuantity);
    }

}


