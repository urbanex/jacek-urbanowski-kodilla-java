package com.kodilla.patterns2.observer.homework;

public class Mentor implements MentorObserver {
    private final String name;
    private int updateCount;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void notifyAboutNewTask(StudentTasks studentTasks) {
        System.out.println("Hey, " + name + "! Your student " + studentTasks.getStudent().getName() +
                " has already solved exercise: " + studentTasks.getExercises().peekLast() +
                ". Total amout of exercises done by him: " + studentTasks.getExercises().size());
        updateCount++;
    }

    public String getName() {
        return name;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
