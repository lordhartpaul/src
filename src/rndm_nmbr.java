public class rndm_nmbr {
    public static void main(String args[])
    {
        System.out.println("Random numbers between 1 and 100 are,");
        for(int i=0;i<100;i++)
            System.out.println("Random number["+(i+1)+"]:"+(int)(Math.random()*1000));
    }

}
