package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TaskFactoryTestSuite {
    private static TaskFactory taskFactory;

    @BeforeClass
    public static void beforeClass() {
        //Given
        taskFactory = new TaskFactory();
    }

    @Test
    public void testFactoryShoppingTask() {
        //When
        Task shopping = taskFactory.makeTask(TaskFactory.SHOPPING);
        shopping.executeTask();
        //Then
        Assert.assertEquals("shopping", shopping.getTaskName());
        Assert.assertTrue(shopping.isTaskExecuted());
    }
    @Test
    public void testFactoryPaintingTask() {
        //When
        Task painting = taskFactory.makeTask(TaskFactory.PAINTING);
        painting.executeTask();
        //Then
        Assert.assertEquals("painting", painting.getTaskName());
        Assert.assertTrue(painting.isTaskExecuted());
    }
    @Test
    public void testFactoryDrivingTask() {
        //When
        Task driving = taskFactory.makeTask(TaskFactory.DRIVING);
        driving.executeTask();
        //Then
        Assert.assertEquals("driving", driving.getTaskName());
        Assert.assertTrue(driving.isTaskExecuted());
    }

    @Test
    public void testFactoryNullTask() {
        //When
        Task doingNothing = taskFactory.makeTask("doingNothing");
        //Then
        Assert.assertNull(doingNothing);
    }
}
