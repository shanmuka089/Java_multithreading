package multiThreading;

class Abcd extends Thread
{
	@Override
	public void run()
	{
		Thread tchild=Thread.currentThread();
		String name=tchild.getName();
		for(char x='a'; x<='z'; x++)
		{
			System.out.println(name+": prints --> "+x);
			try
			{
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class Bcde extends Thread
{
	@Override
	public void run()
	{
		Thread child=new Abcd();
		child.start();
		Thread tparent=Thread.currentThread();
		String name=tparent.getName();
		for(char ch='A'; ch<='Z'; ch++)
		{
			System.out.println(name+": prints --> "+ch);
			try
			{
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class ChildThread {

	public static void main(String[] args) {
		Thread parent=new Bcde();
		parent.start();
		Thread tmain=Thread.currentThread();
		String name=tmain.getName();
		for(int i=1; i<=30; i++)
		{
			System.out.println(name+": prints --> "+i);
			try
			{
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
