package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("shopping", "pumpkin", 2.5);
            case PAINTING:
                return new PaintingTask("painting", "blue", "wall");
            case DRIVING:
                return new DrivingTask("driving", "wherever", "bicycle");
            default:
                return null;
        }
    }

}
