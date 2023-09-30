package multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFrameWorkMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService excute=Executors.newFixedThreadPool(5);
		for(int i=0; i<5; i++) {
			Runnable taskRunnable =new ExecutorFrameWork1(""+i);
			excute.execute(taskRunnable);
		}
		excute.shutdown();
//		while(!excute.isTerminated()) {
//			System.out.println("not terminated");
//		}
		System.out.println("finished all the threads");
	}

}
