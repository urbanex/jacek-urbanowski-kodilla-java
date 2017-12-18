package com.kodilla.patterns2.adapter.company.oldhrsystem;

public class Workers {
    private String[][] workers = {
            {"67032906720", "Walter", "White"},
            {"67032906721", "Jessie", "Pinkman"},
            {"67032906722", "Saul", "Goodman"},
            {"67032906723", "Gustavo", "Fring"},
            {"67032906724", "Hank", "Schrader"}};
    private double[] salaries = {
            50000.00,
            50000.0,
            5350.00,
            9000.00,
            6200.00};

    public String getWorker(int n) {
        if (n > salaries.length) {
            return "";
        }
        return workers[n][0] + ", " + workers[n][2] + ", " + salaries[n];
    }

    public String[][] getWorkers() {
        return workers;
    }

    public double[] getSalaries() {
        return salaries;
    }
}
