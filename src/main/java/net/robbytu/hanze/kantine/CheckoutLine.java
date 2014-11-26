package net.robbytu.hanze.kantine;

import java.util.ArrayList;

/**
 * Created by Dylan on 26-11-2014.
 */
public class CheckoutLine {

    private ArrayList<Person> peopleInLine;
    /**
     * Initializes a new CheckoutLine instance
     */
    public CheckoutLine() {
        this.peopleInLine = new ArrayList<Person>();
    }

    /**
    * Add a person in line
    * @param person Person to add
    */
    public void addPerson(Person person) {
        this.peopleInLine.add(person);
    }
    /**
     * Returns the first person in line. If no one is in line, returns null.
     * @return Person object or null
     */
    public Person eerstePersoonInRij() {
        if(this.isPersonInLine()) {
            Person firstInLine = this.peopleInLine.get(0);
            this.peopleInLine.remove(0);

            return firstInLine;
        }

        return null;
    }
    /**
     * Checks wether there are people in line or not.
     * @return Wether there are people in line or not
     */
    public boolean isPersonInLine() {
        return (this.peopleInLine.size() != 0);
    }
}
