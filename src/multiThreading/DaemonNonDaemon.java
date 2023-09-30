package multiThreading;
class Defg extends Thread
{
	@Override
	public void run()
	{
		Thread tchild=Thread.currentThread();
		tchild.setName("shanmuka");
		String cname=tchild.getName();
		
		for(char c='A'; c<='Z'; c++)
		{
			 System.out.println(cname+": prints--> "+c+" by using daemon?="+tchild.isDaemon());
			 try
			 {
				 Thread.sleep(500);
			 }catch(InterruptedException e) {
				 e.printStackTrace();
			 }
		}
	}
}
class Efgh extends Thread
{
	@Override
	public void run()
	{
		Thread t2=new Defg();
		t2.setDaemon(true);
		t2.start();
		Thread tparent=Thread.currentThread();
		tparent.setName("vedha");
		String pname=tparent.getName();
		
		for(char c='a'; c<='j'; c++)
		{
			System.out.println(pname+": prints--> "+c+" by using daemon?="+tparent.isDaemon());
			try
			{
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class DaemonNonDaemon {

	public static void main(String[] args) {
		Thread t1=new Efgh();
		t1.setDaemon(false);
		t1.start();
		Thread tmain=Thread.currentThread();
		tmain.setName("priya");
		String mname=tmain.getName();
		for(int x=1; x<=30; x++) {
			System.out.println(mname+": prints--> "+x+" by using daemon?="+tmain.isDaemon());
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
