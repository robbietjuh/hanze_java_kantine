package net.robbytu.hanze.kantine;

import java.util.Random;

/**
 * Created by Dylan on 12-12-2014.
 */
public class Student extends Person
{
    private static final String[] STUDIES = {"Software Engineering", "Game Development",
                                             "Teacher Study","Economics", "Actor"};

    private int studentNumber;
    private String study;

    /**
     * Initializes a new instance of the Student class
     * without any parameters
     */
    public Student() {
        super();

        Random random = new Random();

        this.studentNumber = random.nextInt(9999 - 1000) + 1000;
        this.study = STUDIES[random.nextInt(5)];
    }

    /**
     * Initializes a new instance of the Student class with the specified properties
     * @param studentNumber Unique Student ID
     * @param study The name of the study this person is subscribed to
     * @param bsn National security number
     * @param firstname First name
     * @param lastname Last name
     * @param day Birthdate -- day
     * @param month Birthdate -- month
     * @param year Birthdate -- year
     * @param gender Gender
     */
    public Student(int studentNumber, String study, int bsn, String firstname,
                   String lastname, int day, int month, int year, char gender) {
        super(bsn, firstname, lastname, day, month, year, gender);

        this.studentNumber = studentNumber;
        this.study = study;
    }

    /**
     * Returns this student's unique ID
     * @return The student's unique ID
     */
    public int getStudentNumber() {
        return this.studentNumber;
    }

    /**
     * Sets this student's unique ID
     * @param studentNumber This student's unique ID
     */
    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    /**
     * Returns the name of the study this person is subscribed to
     * @return The name of the study this person is subscribed to
     */
    public String getStudy() {
        return this.study;
    }

    /**
     * Sets the name of the study this person is subscribed to
     * @param study The name of the study this person is subscribed to
     */
    public void setStudy(String study) {
        this.study = study;
    }

    /**
     * This method overrides the method in Person
     * and prints studentNumber and study
     */
    @Override
    public void printDetails() {
        System.out.println("Details for the student with studentnumber: " + this.studentNumber);
        System.out.println("This person is studying " + this.study);
    }
}
