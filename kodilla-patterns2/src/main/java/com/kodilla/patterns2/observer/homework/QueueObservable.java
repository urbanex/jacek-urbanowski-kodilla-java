package com.kodilla.patterns2.observer.homework;

public interface QueueObservable {
    void registerObserver(MentorObserver observer);
    void notifyObservers();
    void removeObserver(MentorObserver observer);
}
