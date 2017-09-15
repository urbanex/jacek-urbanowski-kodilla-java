package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");

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

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

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

        System.out.println();

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String inputWord = "aBcDeFgHiJkLmNoPqRsTuWvXyZ";

        System.out.print("converting \"" + inputWord + "\" to uppercase: ");
        System.out.println(poemBeautifier.beautify(inputWord, (str)-> str.toUpperCase()));

        System.out.print("converting \"" + inputWord + "\" to lowercase: ");
        System.out.println(poemBeautifier.beautify(inputWord, (str)-> str.toLowerCase()));

        System.out.print("first 5 letters of \"" + inputWord + "\": ");
        System.out.println(poemBeautifier.beautify(inputWord, (str)-> str.substring(0,5)));

        System.out.print("last 5 letters of \"" + inputWord + "\": ");
        System.out.println(poemBeautifier.beautify(inputWord, (str)-> str.substring(str.length()-5)));

        System.out.print("adding preffix and suffix to \"" + inputWord + "\": ");
        System.out.println(poemBeautifier.beautify(inputWord, (str)-> "~~~" + str + "~~~"));


    }
}