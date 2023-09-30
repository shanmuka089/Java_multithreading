package multiThreading;

public class ExecutorFrameWork1 implements Runnable{
	private String threadno;
	public ExecutorFrameWork1(String no)
	{
		this.threadno=no;
	}
	
	@Override
	public void run()
	{
		System.out.println(Thread.currentThread().getName()+" start execution , with the thread number "+ this.threadno);
		execThread();
		System.out.println(Thread.currentThread().getName()+" stop execution");
	}
	private void execThread()
	{
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
