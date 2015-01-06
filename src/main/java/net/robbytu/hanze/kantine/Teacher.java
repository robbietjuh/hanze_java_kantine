package net.robbytu.hanze.kantine;

import java.util.Random;

/**
 * Created by Dylan on 12-12-2014.
 */
public class Teacher extends Person implements DiscountCardholder
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

        this.teacherDepartment = DEPARTMENTS[random.nextInt(DEPARTMENTS.length)];
        this.teacherAbbreviation = this.generateTeacherAbbreviation(ABBREVIATION_LENGTH, ALLOWED_ABBREVIATION_CHARS);
    }

    /**
     * Initializes a new instance of the Teacher class with the specified properties
     * @param teacherAbbreviation The teacher's abbreviation
     * @param teacherDepartment The department this teacher works in
     * @param bsn National security number
     * @param firstname First name
     * @param lastname Last name
     * @param day Birthdate -- day
     * @param month Birthdate -- month
     * @param year Birthdate -- year
     * @param gender Gender
     */
    public Teacher(String teacherAbbreviation, String teacherDepartment,  int bsn, String firstname,
                   String lastname, int day, int month, int year, char gender) {
        super(bsn, firstname, lastname, day, month, year, gender);

        this.teacherAbbreviation = teacherAbbreviation;
        this.teacherDepartment = teacherDepartment;
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
            abbreviation += allowedChars[random.nextInt(allowedChars.length)];

        return abbreviation;
    }

    /**
     * Returns the teacher's abbrevation
     * @return The teacher's abbrevation
     */
    public String getTeacherAbbreviation() {
        return teacherAbbreviation;
    }

    /**
     * Sets the teacher's abbreviation
     * @param teacherAbbreviation The teacher's abbreviation
     */
    public void setTeacherAbbreviation(String teacherAbbreviation) {
        this.teacherAbbreviation = teacherAbbreviation;
    }

    /**
     * Returns the teacher's department
     * @return The teacher's department
     */
    public String getTeacherDepartment() {
        return teacherDepartment;
    }

    /**
     * Sets the teacher's department
     * @param teacherDepartment The teacher's department
     */
    public void setTeacherDepartment(String teacherDepartment) {
        this.teacherDepartment = teacherDepartment;
    }

    /**
     * Returns teacherAbbreviation and teacherDepartment
     * @return teacherAbbreviation and teacherDepartment
     */
    @Override
    public String toString() {
        return "Details for the teacher with abbreviation: " + this.teacherAbbreviation + "\n" +
               "Department: " + this.teacherDepartment;
    }

    /**
     * Returns the discount percentage this person gets
     * @return Discount percentage
     */
    @Override
    public double getDiscountPercentage() {
        return 25.0;
    }

    /**
     * Returns wether there is a limit for the discount being given
     * @return Wether there is a limit
     */
    @Override
    public boolean hasDiscountLimit() {
        return true;
    }

    /**
     * Returns the limit set for the discount in euros
     * @return Limit in euros
     */
    @Override
    public double getDiscountLimit() {
        return 1.0;
    }
}
