package multiThreading;
class PrintShop5
{
	public void print(int x, int y)
	{
		for(int i=x; i<=y; i++)
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
class Customer5 extends Thread
{
	PrintShop5 ab;
	int x;
	int y;
	Customer5(PrintShop5 ab, int x, int y){
		this.ab=ab;
		this.x=x;
		this.y=y;
	}
	@Override
	public void run()
	{
		synchronized(this) {
			System.out.println(Thread.currentThread().getName()+" puts lock");
			ab.print(x,y);
		}
	}
}

public class SynchronizedBliock2 {

	public static void main(String[] args) {
		PrintShop5 p=new PrintShop5();
		Thread cu1=new Customer5(p,10,30);
		Thread cu2=new Customer5(p,40,60);
		cu1.start();
		cu2.start();

	}

}
