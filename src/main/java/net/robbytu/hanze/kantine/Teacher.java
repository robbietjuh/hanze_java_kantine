package net.robbytu.hanze.kantine;

import java.util.Random;

/**
 * Created by Dylan on 12-12-2014.
 */
public class Teacher extends Person
{
    private static final String[] DEPARTMENTS = {"Chemics Lab", "Computer Lab", "Lecture Hall",
                                                 "Anime room", "Study Hall"};

    private static final char[] ALLOWED_ABBREVIATION_CHARS = {'A','B','C','D','E','F','G','H','I','j','K','L','M','N',
                                                              'O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    private static final int ABBREVIATION_LENGTH = 5;

    private String teacherAbbreviation;
    private String teacherDepartment;

    /**
     * Initializes a new instance of the Teacher class
     * without any parameters
     */
    public Teacher() {
        super();

        Random random = new Random();

        this.teacherDepartment = DEPARTMENTS[random.nextInt(DEPARTMENTS.length + 1)];
        this.teacherAbbreviation = this.generateTeacherAbbreviation(ABBREVIATION_LENGTH, ALLOWED_ABBREVIATION_CHARS);
    }

    /**
     * Generates a new random abbreviation
     * @param abbrevationLength The length of the abbrevation to generate
     * @param allowedChars The chars to use for generating a new abbreviation
     * @return Teacher abbrevation
     */
    private String generateTeacherAbbreviation(int abbrevationLength, char[] allowedChars) {
        String abbreviation = "";
        Random random = new Random();

        for(int i = 0; i < abbrevationLength; i++)
            teacherAbbreviation += allowedChars[random.nextInt(allowedChars.length + 1)];

        return abbreviation;
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
