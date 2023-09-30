package multiThreading;

import java.util.Scanner;

public class WaitNotifyDemo {
	
	public static void main(String[] args) {
		
		Processor2 process = new Processor2();
//		Anonymous class
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					process.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
//		Anonymous class
		Thread t2 = new Thread(new Runnable(){

			@Override
			
			public void run() {
				try {
					process.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		t1.start();
		t2.start();
		
		
	}

}


class Processor2{
	
	public void producer() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer started Producing");
			wait();// we should always use wait in while() loop not in if block
			System.out.println("Resumed");
		}
		
	}
	
	public void consumer() throws InterruptedException{
		Thread.sleep(1000);
		Scanner sc = new Scanner(System.in);
		synchronized (this) {
			System.out.println("Enter Any Key to Continue");
			sc.nextLine();
			notify();
    //notifyAll()   // if there are more than 2 threads are in program we will use notifyAll()
			
		}
		
	}
	
}