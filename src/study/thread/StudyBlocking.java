package site.saishin.study.java8.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class StudyBlocking {

	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

		Future<Integer> f = es.submit(() -> {
			System.out.println("test");
			return queue.poll(10, TimeUnit.SECONDS);
		});

		es.execute(() -> {
			System.out.println("test");
			try {
				while (true)
					System.out.println(queue.poll(10, TimeUnit.SECONDS));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		for (int i = 0; i < 10000; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			queue.offer(i);
		}
		es.shutdown();
	}

}
