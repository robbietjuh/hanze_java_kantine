package net.robbytu.hanze.kantine;

/**
 * Created by Dylan on 7-1-2015.
 */
public class TooLittleMoneyException extends Exception
{
    /**
     * Too low a balance
     */
    public TooLittleMoneyException()
    {
        super();
    }

    /**
     * Too low a balance
     * @param e Exception
     */
    public TooLittleMoneyException(Exception e)
    {
        super(e);
    }

    /**
     * Too low a balance
     * @param Message Message to throw
     */
    public TooLittleMoneyException(String Message)
    {
        super(Message);
    }
}
