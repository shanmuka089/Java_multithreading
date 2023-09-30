package multiThreading;
class PrintShop
{
	public synchronized void print(int x,int y)
	{
		for(int i=x; i<=y; i++) {
			System.out.println(i);
		try {
			Thread.sleep(500);
		}catch(InterruptedException e) {
			e.printStackTrace();
			}
		}
	}
}
class Customer extends Thread
{
	PrintShop ab;
	int x;
	int y;
	int n;
	Customer(PrintShop ab, int x, int y,int n)
	{
		this.ab=ab;
		this.x=x;
		this.y=y;
		this.n=n;
	}
	public void run()
	{
		System.out.println("customer "+n+" is called:");
		ab.print(x,y);
	}
}
public class SynchronaizeThread {
	public static void main(String[] args) {
		PrintShop ab=new PrintShop();
		Thread cu1=new Customer(ab,10,30,1);
		System.out.println("customer 1 arrives:");
		cu1.start();
		Thread cu2=new Customer(ab,70,80,2);
		System.out.println("customer 2 arrives:");
		cu2.start();
	}
}
