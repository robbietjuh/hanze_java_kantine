package net.robbytu.hanze.kantine;

import java.util.Random;

/**
 * Created by Dylan on 12-12-2014.
 */
public class Student extends Person
{
    private int studentNumber;
    private String study;


    /**
     * Initializes a new instance of the Student class
     * without any parameters
     */
    public Student()
    {
        Random random = new Random();
        studentNumber = random.nextInt(9999 - 1000) + 1000;
        int tempNumber = random.nextInt(5);
        String[] studies = {"Software Engineering", "Game Development", "Teacher Study", "Economics", "Actor"};
        this.study = studies[tempNumber];
    }

    public Student(int studentNumber, String study, int bsn, String firstname, String lastname, int day, int month, int year, char gender)
    {
        super();

        setBsn(bsn);
        setFirstname(firstname);
        setLastname(lastname);
        setBirthdate(day, month, year);
        setGender(gender);

        this.studentNumber = studentNumber;
        this.study = study;
    }

    public String getStudy()
    {
        return study;
    }

    public void setStudy(String study)
    {
        this.study = study;
    }

    public int getStudentNumber()
    {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber)
    {
        this.studentNumber = studentNumber;
    }

    /**
     * This method overrides the method in Person
     * and prints studentNumber and study
     */
    @Override
    public void printDetails()
    {
        System.out.println("Details for the student with studentnumber: " + this.studentNumber);
        System.out.println("Study: " + study);
    }
}
