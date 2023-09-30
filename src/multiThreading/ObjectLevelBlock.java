package multiThreading;
class PrintShop2
{
	public	synchronized void print(int a,int b)
	{
		for(int i=a; i<=b; i++)
		{
			System.out.println(i);
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class ShanuVedha extends Thread
{
	public void run()
	{
		for(char i='A'; i<='Z'; i++) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
class Customer2 extends Thread
{
	PrintShop2 ab;
	int x;
	int y;
	Customer2(PrintShop2 ab, int x, int y){
		this.ab=ab;
		this.x=x;
		this.y=y;
	}
	@Override
	public void run()
	{
		System.out.println("thread is start printing");
		ab.print(x,y);
	}
}
public class ObjectLevelBlock {

	public static void main(String[] args) {
		PrintShop2 p=new PrintShop2();
		Thread cu1=new Customer2(p,10,30);
		Thread cu2=new Customer2(p,70,90);
		Thread s1=new ShanuVedha();
		s1.setDaemon(true);
		System.out.println(Thread.currentThread().getState());
		cu1.start();
		s1.start();
		cu2.start();
	}
}
