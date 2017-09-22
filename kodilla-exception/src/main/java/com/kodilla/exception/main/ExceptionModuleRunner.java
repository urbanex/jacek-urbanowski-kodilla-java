package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.io.FileReaderWithoutHandling;

import java.io.IOException;

public class ExceptionModuleRunner {

    public static void main(String args[]) {

        //moduł 8.1 przykład
        /*FileReader fileReader = new FileReader();
        fileReader.readFile();*/

        //moduł 8.3
        FileReaderWithoutHandling fileReaderWithoutHandling = new FileReaderWithoutHandling();

        try {
            fileReaderWithoutHandling.readFile();
        } catch (IOException e) {
            System.out.println("Oh no!!!!!!! Sth went wrong ¯\\_(ツ)_/¯");
        }

        System.out.println();

        FileReader fileReader = new FileReader();

        try {
            fileReader.readFile();
        } catch (FileReaderException e) {
            System.out.println("Oh no!!!!!!! Sth went wrong ¯\\_(ツ)_/¯");
        }

        System.out.println();

        //8.3 zadanie



    }

}
