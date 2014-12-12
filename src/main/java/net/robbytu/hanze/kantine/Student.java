package net.robbytu.hanze.kantine;

/**
 * Created by Dylan on 12-12-2014.
 */
public class Student extends Person
{
    private int studentNumber;
    private String study;


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
