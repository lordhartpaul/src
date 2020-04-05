class myexception extends Exception {
    private int detail;
    myexception(int a)
    {
        detail=a;
    }
    public String tostring()
    {
        return "myexception["+detail+ "]";
    }

}
class exceptiondemo{
    static void compute(int a) throws myexception
    {
        System.out.println("called compute("+a+")");
        if(a>10)
            throw new myexception(a);
        System.out.println("normal exit");
    }
    public static void main(String args[])
    {
        try
        {
            compute(1);
            compute(20);
        }
        catch(myexception e)
        {
            System.out.println("caught" +e);
        }
    }
}
