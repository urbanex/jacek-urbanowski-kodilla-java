package com.kodilla.spring.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class Library {
    private final List<String> books = new ArrayList<>();
    @Autowired
    private LibraryDbController libraryDbController;

    //wstrzykiwanie konstruktorem
/*    @Autowired
    public Library(final LibraryDbController libraryDbController) {
        this.libraryDbController = libraryDbController;
    }

    public Library() {
    }*/

    //wstrzykiwanie setterem, ale tego nie lubimy bo to przeczy idei niemutowalności obiektów
/*
    @Autowired
    public void setLibraryDbController(LibraryDbController libraryDbController) {
        this.libraryDbController = libraryDbController;
    }
*/

    //wstrzykiwanie bezposrednio do wlasciwosci klasy - @Autowired przed polem klasy

    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }
}