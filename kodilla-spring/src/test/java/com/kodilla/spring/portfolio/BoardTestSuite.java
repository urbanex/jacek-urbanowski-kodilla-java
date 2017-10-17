package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring.portfolio");
        Board board = context.getBean(Board.class);

        boolean addTask1 = board.getDoneList().addTask("zadanie 1 wykonane");
        boolean addTask2 = board.getInProgressList().addTask("zadanie 2 w toku");
        boolean addTask3 = board.getToDoList().addTask("zadanie 3 na przyszlosc");

        System.out.println(board.getDoneList().getTasks().get(0));
        System.out.println(board.getInProgressList().getTasks().get(0));
        System.out.println(board.getToDoList().getTasks().get(0));

        Assert.assertTrue(addTask1);
        Assert.assertTrue(addTask2);
        Assert.assertTrue(addTask3);
    }
}
