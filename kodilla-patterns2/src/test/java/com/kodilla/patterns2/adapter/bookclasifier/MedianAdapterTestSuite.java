package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedian() {
        //given
        Book book1 = new Book("jan", "nowak", 2008, "24125322");
        Book book2 = new Book("jan", "kozak", 2002, "31232113");
        Book book3 = new Book("jan", "młotek", 2010, "23131345");
        Set<Book> books = new HashSet<>(Arrays.asList(book1, book2, book3));
        MedianAdapter medianAdapter = new MedianAdapter();
        //when
        int median = medianAdapter.publicationYearMedian(books);
        //then
        assertEquals(2008, median);
    }
}