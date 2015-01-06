package net.robbytu.hanze.kantine;

import java.util.*;

/**
 * Created by Dylan on 26-11-2014.
 */
public class CheckoutLine {
    private LinkedList<Person>  peopleInLine;

    /**
     * Initializes a new CheckoutLine instance
     */
    public CheckoutLine() {
        this.peopleInLine = new LinkedList<Person>();
    }

    /**
    * Add a person in line
    * @param person Person to add
    */
    public void addPerson(Person person) {
        this.peopleInLine.addLast(person);
    }

    /**
     * Returns the first person in line. If no one is in line, returns null.
     * @return Person object or null
     */
    public Person getFirstPersonInLine() {
        return this.peopleInLine.pollFirst();
    }

    /**
     * Checks wether there are people in line or not.
     * @return Wether there are people in line or not
     */
    public boolean isPersonInLine() {
        return (this.peopleInLine.size() != 0);
    }
}
