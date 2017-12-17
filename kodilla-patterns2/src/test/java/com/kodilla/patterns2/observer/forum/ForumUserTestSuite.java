package com.kodilla.patterns2.observer.forum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ForumUserTestSuite {
    @Test
    public void update() {
        //given
        ForumTopic javaHelpForum = new JavaHelpForumTopic();
        ForumTopic javaToolsForum = new JavaToolsForumTopic();
        ForumUser walterWhite = new ForumUser("Walter White");
        ForumUser saulGoodman = new ForumUser("Saul Goodman");
        ForumUser jessiePinkman = new ForumUser("Jessie Pinkman");
        javaHelpForum.registerObserver(walterWhite);
        javaToolsForum.registerObserver(saulGoodman);
        javaHelpForum.registerObserver(jessiePinkman);
        javaToolsForum.registerObserver(jessiePinkman);
        //when
        javaHelpForum.addPost("Hi everyone! Could you help me with for loop?");
        javaHelpForum.addPost("Better try to use while loop in this case.");
        javaToolsForum.addPost("Help pls, my MySQL db doesn't want to work :(");
        javaHelpForum.addPost("Why while? Is it better?");
        javaToolsForum.addPost("When I Try to log in I got 'bad credentials' message.");
        //then
        assertEquals(3, walterWhite.getUpdateCount());
        assertEquals(2, saulGoodman.getUpdateCount());
        assertEquals(5, jessiePinkman.getUpdateCount());
    }

}