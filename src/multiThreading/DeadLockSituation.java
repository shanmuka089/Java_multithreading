package multiThreading;
class WareHouse2
{
	int noofproduct;
	public WareHouse2(int noofproduct)
	{
		this.noofproduct=noofproduct;
	}
	synchronized public void store(int items)
	{
		int temp=noofproduct;
		temp=temp+items;
		try
		{
			Thread.sleep(200);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		noofproduct=temp;
		System.out.println("Items are stored into the ware house the present available items are:"+noofproduct);
	}
	synchronized public void purchase(int items)
	{
		while(items>noofproduct)
		{
			System.out.println("items out of stock please wait...");
			try{
				this.wait(600);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		noofproduct=noofproduct-items;
		System.out.println("Items are purchased successfully, number of products left:"+noofproduct);
	}
}
public class DeadLockSituation {

	public static void main(String[] args) {
		WareHouse2 w1=new WareHouse2(2500);
//		here only purschase method only executes & goes into infinite loop
		w1.purchase(3500);
		w1.store(2500);
		
		
	}

}
