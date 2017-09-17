package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.person.People;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        //System.out.println("Welcome to module 7 - Stream");

        //OOP
        /*SaySomething saySomething = new SaySomething();
        saySomething.say();

        Processor processor = new Processor();
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);

        Processor processor = new Processor();
        Executor codeToExecute = () -> System.out.println("This is an example text.");
        processor.execute(codeToExecute);

        Processor processor = new Processor();
        processor.execute(() -> System.out.println("This is an example text."));*/


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


        //MODUŁ 7.2 przykład
        /*System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);*/

        //MODUŁ 7.3 przykład

        /*People.getList().stream()
                .map(s -> s.toUpperCase())
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println);*/

        /*BookDirectory theBookDirectory = new BookDirectory();
        theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .forEach(System.out::println);*/

        //Kolektor Collectors.toList()
        /*BookDirectory theBookDirectory = new BookDirectory();
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("# elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);*/

        //Kolektor Collectors.toMap()
        /*BookDirectory theBookDirectory = new BookDirectory();

        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));////// CO TU SIE DZIEJE?

        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);*/

        //Kolektor Collectors.joining()
        /*BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);*/

        //MODUŁ 7.3 zadanie

        Forum theUserList = new Forum();
        Map<Integer, ForumUser> theResultMap = theUserList.getUserList().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> LocalDate.now().getYear() - user.getBirthDate().getYear() > 20)
                .filter(user -> user.getPostQuantity() > 0)
                .collect(Collectors.toMap(ForumUser::getUserID, user -> user));

        System.out.println("# elements: " + theResultMap.size());
        theResultMap.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}