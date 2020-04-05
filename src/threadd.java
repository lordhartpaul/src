public class threadd extends Thread 
{
    private int i;

    private threadd(int i) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
	public void run(int i) throws InterruptedException
	{	
		for(this.i=0;i<10;++i)
		{
			System.out.println("HELLO" + i);
			Thread.sleep(100);			
		}		
	}
	public static void main(String args[])
	{
		Thread t=new threadd(1);
		t.start();
	}
}
