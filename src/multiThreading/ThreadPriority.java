package multiThreading;

public class ThreadPriority extends Thread {

	public static void main(String[] args) {
		Thread ab=new ThreadPriority();
		ab.setName("Vedha");
		ab.setPriority(3);
		Thread p=new ThreadPriority();
		p.setName("Shanu");
		p.setPriority(7);
		ab.start();
		p.start();
		Thread k=Thread.currentThread();
		System.out.println(k.getName()+" and having a priority of "+k.getPriority());
		System.out.println(k.getState());
		
	}
	@Override
	public void run()
	{
		Thread k=Thread.currentThread();
		System.out.println(k.getName()+" and having a priority of "+k.getPriority());
	}

}
