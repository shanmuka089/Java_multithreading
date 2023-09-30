package multiThreading;
class Def implements Runnable
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
public class ImplementingRunnable {

	public static void main(String[] args) {
		Runnable r1=new Def();
		Thread t1=new Thread(r1);
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