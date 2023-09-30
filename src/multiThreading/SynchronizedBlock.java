package multiThreading;
class PrintShop4
{
	public void print(int x, int y)
	{
		System.out.println("welcome to print shop");
		System.out.println("this method print number from a to b range");
		System.out.println("you can see number printing");
		synchronized(this)
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
	public static void print(char x, char y)
	{
		System.out.println("welcome to print shop");
		System.out.println("this method print characters from a to b range");
		System.out.println("you can see character printing");
		synchronized(PrintShop4.class)
		{
			for(char c=x; c<=y; c++)
			{
				System.out.println(c);
				try {
					Thread.sleep(500);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
class Custom1 extends Thread
{
	PrintShop4 ab;
	int x;
	int y;
	Custom1(PrintShop4 ab,int x, int y)
	{
		this.ab=ab;
		this.x=x;
		this.y=y;
	}
	@Override
	public void run()
	{
		ab.print(x,y);
	}
}
class Custom2 extends Thread
{
	char x;
	char y;
	Custom2(char x,char y)
	{
		this.x=x;
		this.y=y;
	}
	@Override
	public void run()
	{
		PrintShop4.print(x,y);
	}
}

public class SynchronizedBlock {

	public static void main(String[] args) {
		PrintShop4 p=new PrintShop4();
		Thread cu1=new Custom1(p,10,40);
		Thread cu1a=new Custom1(p,50,80);
		Thread cu2a=new Custom2('A','Z');
		Thread cu2=new Custom2('a','z');
		cu1.start();
		cu2.start();
		cu1a.start();
		cu2a.start();
	}

}
