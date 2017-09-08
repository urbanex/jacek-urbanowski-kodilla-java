package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.*;

public class ForumTestSuite {

    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }

    @After
    public void after(){
        System.out.println("Test Case: end");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }

    @Test
    public void testCaseUsername(){
        //given
        SimpleUser simpleUser = new SimpleUser("nowaczek", "Jan Nowak");
        //when
        String result = simpleUser.getUsername();
        System.out.println("Testing: " + result);
        //then
        Assert.assertEquals("nowaczek", result);
    }

    @Test
    public void testCaseRealName(){
        //given
        SimpleUser simpleUser = new SimpleUser("nowaczek", "Jan Nowak");
        //when
        String result = simpleUser.getRealName();
        System.out.println("Testing: " + result);
        //then
        Assert.assertEquals("Jan Nowak", result);
    }


}
