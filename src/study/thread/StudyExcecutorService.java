package site.saishin.study.java8.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StudyExcecutorService {
	public static void main(String[] args) {
		ExecutorService es = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			es.execute(() -> {
				String name = Thread.currentThread().getName();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(name);
			});
		}
		Callable<Integer> task = new Callable<Integer>() {
			int count = 0;
			@Override
			public Integer call() throws Exception {
				Thread.sleep(1000);
				return count++;
			}
		};
		try {
			for(int i = 0; i < 10; i++) {
				Integer val = es.submit(task).get();
				System.out.println(val);
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		es.shutdown();
		es = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			es.execute(() -> {
				String name = Thread.currentThread().getName();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(name);
			});
		}
		es.shutdown();
	}
}
