package net.robbytu.hanze.kantine;

import java.util.Random;

/**
 * Created by Dylan on 12-12-2014.
 */
public class Teacher extends Person
{
    private String teacherAbbreviation;
    private String teacherDepartment;

    /**
     * Initializes a new instance of the Teacher class
     * without any parameters
     */
    public Teacher()
    {

        Random random = new Random();
        int tempNumber = random.nextInt(5);
        String[] departments = {"Chemics Lab", "Computer Lab", "Lecture Hall", "Anime room", "Study Hall"};
        this.teacherDepartment = departments[tempNumber];
        char[] letters = {'A','B','C','D','E','F','G','H','I','j','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        for(int i = 0; i < 5; i++)
        {
            tempNumber = random.nextInt(26);
            teacherAbbreviation += letters[tempNumber];
        }
    }
    
    public Teacher(String teacherAbbreviation, String teacherDepartment,  int bsn, String firstname, String lastname, int day, int month, int year, char gender)
    {
        super();

        setBsn(bsn);
        setFirstname(firstname);
        setLastname(lastname);
        setBirthdate(day, month, year);
        setGender(gender);


        this.teacherAbbreviation = teacherAbbreviation;
        this.teacherDepartment = teacherDepartment;
    }

    public String getTeacherAbbreviation()
    {
        return teacherAbbreviation;
    }

    public void setTeacherAbbreviation(String teacherAbbreviation)
    {
        this.teacherAbbreviation = teacherAbbreviation;
    }

    public String getTeacherDepartment()
    {
        return teacherDepartment;
    }

    public void setTeacherDepartment(String teacherDepartment)
    {
        this.teacherDepartment = teacherDepartment;
    }

    /**
     * This method overrides the method in Person
     * and prints teacherAbbreviation and teacherDepartment
     */
    @Override
    public void printDetails()
    {
        System.out.println("Details for the teacher with abbreviation: " + this.teacherAbbreviation);
        System.out.println("Department: " + teacherDepartment);
    }
}
