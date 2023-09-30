package multiThreading;
class ShowRoom extends Thread
{
	int items;
	WareHouse ab;
	ShowRoom(WareHouse ab,int items)
	{
		this.items=items;
		this.ab=ab;
	}
	@Override
	public void run()
	{
		ab.purchase(items);
	}
}
class Manufacture extends Thread
{
	int items;
	WareHouse ab;
	Manufacture(WareHouse ab,int items)
	{
		this.ab=ab;
		this.items=items;
	}
	@Override
	public void run()
	{
		ab.store(items);
	}
}
public class ManufactureShowRoom {

	public static void main(String[] args) {
		WareHouse w1=new WareHouse(1000);
		Manufacture m1=new Manufacture(w1,500);
		ShowRoom s1=new ShowRoom(w1,1400);
		m1.start();
		s1.start();
		ShowRoom s2=new ShowRoom(w1,500);
		s2.start();
		Manufacture m2=new Manufacture(w1,500);
		m2.start();
	}

}
