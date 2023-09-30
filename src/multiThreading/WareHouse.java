package multiThreading;

public class WareHouse {
	int noofproducts;
	WareHouse(int noofproducts)
	{
		this.noofproducts=noofproducts;
	}
	synchronized public void store(int items)
	{
		int temp=noofproducts;
		temp=temp+items;
		noofproducts=temp;
		System.out.println("the items are stored into the ware house,the current available items are:"+noofproducts);
		try {
			Thread.sleep(300);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	synchronized public void purchase(int items)
	{
		if(items>noofproducts) {
			System.out.println("please wait the products are out of stock...");
			try {
				Thread.sleep(600);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		noofproducts=noofproducts-items;
		System.out.println("the products of "+items+" are purchased successfully now present available stock in warehouse "+noofproducts);
	}
}
