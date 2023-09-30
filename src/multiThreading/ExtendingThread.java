package multiThreading;
class Abc extends Thread
{
	@Override
	public void run()
	{
		for(char c='a'; c<='z'; c++) {
			System.out.println(c);
			try
			{
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class ExtendingThread {

	public static void main(String[] args) {
		Thread t1=new Abc();
		t1.start();
		for(int i=1; i<=30; i++) {
			System.out.println(i);
			try
			{
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
