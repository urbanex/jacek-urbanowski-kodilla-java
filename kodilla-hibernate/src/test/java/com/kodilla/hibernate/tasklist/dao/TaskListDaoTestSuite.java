package com.kodilla.hibernate.tasklist.dao;


import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList1 = new TaskList("tasklist1", "description of first task");
        TaskList taskList2 = new TaskList("tasklist2", "description of second task");
        //when
        taskListDao.save(taskList1);
        taskListDao.save(taskList2);

        //Then
        String listName2 = taskList2.getListName();
        List<TaskList> readTaskList = taskListDao.findByListName(listName2);
        Assert.assertEquals(1, readTaskList.size());
        Assert.assertEquals(listName2, readTaskList.get(0).getListName());

        //CleanUp
        taskListDao.delete(taskList1.getId());
        taskListDao.delete(taskList2.getId());
    }
}
