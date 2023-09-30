package multiThreading;
class Thread_Abc extends Thread
{
	@Override
	public void run() {
	for(int i=1; i<=20; i++)
	{
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread 2"+Thread.currentThread().getName());
		System.out.println(i);
	}
	}
}

public class Practice1 extends Thread {

	public static void main(String[] args){
		Thread t1=new Practice1();
		Thread t2=new Thread_Abc();
		System.out.println("Thread 0"+Thread.currentThread().getName());
		t1.setDaemon(true);
		t1.setPriority(2);
		System.out.println(t1.getPriority());
		System.out.println(t1.isDaemon());
		t1.start();
		t2.start();
		}
	@Override
	public void run()
	{
		for(char c='A'; c<='Z'; c++)
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread 1"+Thread.currentThread().getName());
			System.out.println(c);
		}
	}
}
