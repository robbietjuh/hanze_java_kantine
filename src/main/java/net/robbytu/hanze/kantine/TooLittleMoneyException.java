package net.robbytu.hanze.kantine;

/**
 * Created by Dylan on 7-1-2015.
 */
public class TooLittleMoneyException extends Exception
{
    public TooLittleMoneyException()
    {
        super();
    }

    public TooLittleMoneyException(Exception e)
    {
        super(e);
    }

    public TooLittleMoneyException(String Message)
    {
        super(Message);
    }
}
