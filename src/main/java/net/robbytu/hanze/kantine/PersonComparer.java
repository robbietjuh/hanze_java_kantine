package net.robbytu.hanze.kantine;

/**
 * Created by Dylan on 6-1-2015.
 */
public class PersonComparer
{
    public static void main(String[] args)
    {
        Person person1 = new Person(1234, "Robert", "de Vries", 11, 10, 1996, 'M');
        Person person2 = new Person(1234, "Robert", "de Vries", 11, 10, 1996, 'M');
        if(person1.equals(person2))
        {
            System.out.println("person1 is equal to person2, using equals()");
        }
        else
        {
            System.out.println("person1 is not equal to person2, using equals");
        }

        if (person1 == person2)
        {
            System.out.println("person1 is equal to person2, using ==");
        }
        else
        {
            System.out.println("person1 is not equal to person2, using ==");
        }
    }
}
