package net.robbytu.hanze.kantine;

/**
 * Created by Dylan on 12-12-2014.
 */
public class Teacher extends Person
{
    private String teacherAbbreviation;
    private String teacherDepartment;

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
}
