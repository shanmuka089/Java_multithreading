package multiThreading;
class Ghij extends Thread
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

public class ThreadByExtending2 {
		public static void main(String[] args) {
			Thread t1=new Ghij();
			t1.start();
			t1=new Ghij();
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
