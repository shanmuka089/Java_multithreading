package multiThreading;
public class WaitNotifyTest {
	   private static final long SLEEP_INTERVAL = 3000;
	   private boolean running = true;
	   
	   public void start() {
	      print("Inside start() method");
//	      anonymous class
	      Thread thread = new Thread(new Runnable() {
	         @Override
	         public void run() {
	            print("Inside run() method");
	            try {
	               Thread.sleep(SLEEP_INTERVAL);
	            } catch(InterruptedException e) {
	               e.printStackTrace();
	            }
//	            synchronized block
	            synchronized(WaitNotifyTest.this) {
	               running = false;
	               WaitNotifyTest.this.notify();
	            }
	         }
	      });
	      thread.start();
	   }
	   public void join() throws InterruptedException {
	      print("Inside join() method");
	      synchronized(this) {
	         while(running) {
	            print("Waiting for the peer thread to finish.");
	            wait(); //waiting, not running
	         }
	         print("Peer thread finished.");
	      }
	   }
//	   print method
	   private void print(String s) {
	      System.out.println(s);
	   }
	   public static void main(String[] args) throws InterruptedException {
	      WaitNotifyTest test = new WaitNotifyTest();
	      test.start();
	      test.join();
	   }
	}