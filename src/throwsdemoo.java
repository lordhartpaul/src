class throwsdemoo
{
    static void throwone() throws IllegalAccessException
    {
        System.out.println("inside throwone");
        throw new IllegalAccessException("demo");
    }
    public static void main(String args[])
    {
        try
        {
            throwone();
        }
        catch(IllegalAccessException e)
        {
           System.out.println("Exception occurs" +e);  
        }
    }
}