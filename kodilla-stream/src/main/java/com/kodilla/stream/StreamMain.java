package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        //System.out.println("Welcome to module 7 - Stream");

        //OOP
        //SaySomething saySomething = new SaySomething();
        //saySomething.say();

        //Processor processor = new Processor();
        //ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        //processor.execute(executeSaySomething);

        //Processor processor = new Processor();
        //Executor codeToExecute = () -> System.out.println("This is an example text.");
        //processor.execute(codeToExecute);

        //Processor processor = new Processor();
        //processor.execute(() -> System.out.println("This is an example text."));


        //MODUŁ 7.1 przykład
        /*ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println();

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        System.out.println();*/

        //MODUŁ 7.1 zadanie
        /*PoemBeautifier poemBeautifier = new PoemBeautifier();
        String inputWord = "aBcDeFgHiJkLmNoPqRsTuWvXyZ";

        System.out.print("converting \"" + inputWord + "\" to uppercase: ");
        System.out.println(poemBeautifier.beautify(inputWord, String::toUpperCase));  //referencja do metody

        System.out.print("converting \"" + inputWord + "\" to lowercase: ");
        System.out.println(poemBeautifier.beautify(inputWord, str -> str.toLowerCase())); // wyrazenie lambda

        System.out.print("first 5 letters of \"" + inputWord + "\": ");
        System.out.println(poemBeautifier.beautify(inputWord, str -> str.substring(0,5)));

        System.out.print("last 5 letters of \"" + inputWord + "\": ");
        System.out.println(poemBeautifier.beautify(inputWord, str -> str.substring(str.length()-5)));

        System.out.print("adding preffix and suffix to \"" + inputWord + "\": ");
        System.out.println(poemBeautifier.beautify(inputWord, str -> "~~~" + str + "~~~"));*/

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

    }
}