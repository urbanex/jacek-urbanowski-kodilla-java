package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> theUserList = new ArrayList<>();

    public Forum() {
        theUserList.add(new ForumUser(1, "michal", 'M', LocalDate.of(1980,12,12), 2));
        theUserList.add(new ForumUser(2, "patryk", 'M', LocalDate.of(1985,5,29), 21));
        theUserList.add(new ForumUser(3, "ola", 'F', LocalDate.of(1983,7,3), 0));
        theUserList.add(new ForumUser(4, "kamila", 'F', LocalDate.of(1989,8,22), 1));
        theUserList.add(new ForumUser(5, "karol", 'M', LocalDate.of(1990,9,9), 0));
        theUserList.add(new ForumUser(6, "matylda", 'F', LocalDate.of(1992,3,12), 11));
        theUserList.add(new ForumUser(7, "andrzej", 'M', LocalDate.of(1984,4,17), 2));
        theUserList.add(new ForumUser(8, "kamil", 'M', LocalDate.of(1985,7,11), 0));
        theUserList.add(new ForumUser(9, "patrycja", 'F', LocalDate.of(1987,10,5), 7));
        theUserList.add(new ForumUser(10, "krzysztof", 'M', LocalDate.of(1975,12,31), 2));
        theUserList.add(new ForumUser(11, "sylwia", 'F', LocalDate.of(1977,11,25), 1));
    }

    public List<ForumUser> getUserList() {
        return theUserList;
    }
}
