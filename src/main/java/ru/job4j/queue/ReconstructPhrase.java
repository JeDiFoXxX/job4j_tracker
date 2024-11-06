package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder array = new StringBuilder();
        int size = evenElements.size();
        for (int index = 0; index < size; index++) {
            char element = evenElements.pollFirst();
            if (index % 2 == 0) {
                array.append(element);
            }
        }
        return array.toString();
    }

    private String getDescendingElements() {
        StringBuilder array = new StringBuilder();
        int size = descendingElements.size();
        for (int index = 0; index < size; index++) {
                array.append(descendingElements.pollLast());
            }
        return array.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}