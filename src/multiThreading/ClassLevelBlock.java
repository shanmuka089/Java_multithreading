package multiThreading;
class PrintShop3
{
	public static synchronized void print(int a,int b)
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
	public static void shannu()
	{
		for(char i='A'; i<='Z'; i++)
		{
			System.out.println(i);
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				System.out.println();
			}
		}
	}
}
class Customer3 extends Thread
{
	int x;
	int y;
	Customer3(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	@Override
	public void run() {
		PrintShop3.print(x,y);
		PrintShop3.shannu();
	}
}
public class ClassLevelBlock {

	public static void main(String[] args) {
		Thread cu1=new Customer3(10,20);
		Thread cu2=new Customer3(70,90);
		cu1.start();
		cu2.start();
	}

}
