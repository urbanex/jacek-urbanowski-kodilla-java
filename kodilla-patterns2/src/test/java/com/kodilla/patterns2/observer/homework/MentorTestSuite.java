package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class MentorTestSuite {
    @Test
    public void notifyAboutNewTask() {
        //given
        StudentTasks walterWhiteTasks = new StudentTasks(new Student("Walter White"));
        StudentTasks jessiePinkmanTasks = new StudentTasks(new Student("Jessie Pinkman"));
        StudentTasks saulGoodmanTasks = new StudentTasks(new Student("Saul Goodman"));
        Mentor jurekKiller = new Mentor("Jurek Killer");
        Mentor tommyLeeJones = new Mentor("Tommy Lee Jones");

        walterWhiteTasks.registerObserver(jurekKiller);
        jessiePinkmanTasks.registerObserver(jurekKiller);
        saulGoodmanTasks.registerObserver(tommyLeeJones);

        //when
        walterWhiteTasks.addTaskToQueue("zadanie 20.1");
        saulGoodmanTasks.addTaskToQueue("zadanie 18.1");
        walterWhiteTasks.addTaskToQueue("zadanie 20.2");
        walterWhiteTasks.addTaskToQueue("zadanie 20.3");
        jessiePinkmanTasks.addTaskToQueue("zadanie 10.1");
        saulGoodmanTasks.addTaskToQueue("zadanie 18.2");

        //then
        assertEquals(4, jurekKiller.getUpdateCount());
        assertEquals(2, tommyLeeJones.getUpdateCount());
        assertEquals(1, jessiePinkmanTasks.getExercises().size());
        assertEquals(2, saulGoodmanTasks.getExercises().size());
        assertEquals(3, walterWhiteTasks.getExercises().size());
    }
}