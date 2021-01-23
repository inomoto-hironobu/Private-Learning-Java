package study.stdlib.thread;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadApp {

	public static void main(String[] args) {
		Reflector reflector = new Reflector();
		ArrayList<RunnableClass> threads = new ArrayList<>();
		for(int i = 0; i < 100; i++) {
			RunnableClass thread = new RunnableClass(reflector);
			threads.add(thread);
		}
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		threads.forEach((t)->{executorService.execute(t);});
		executorService.shutdown();
	}
	static class CallableClass<V> implements Callable<V> {

		@Override
		public V call() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	static class RunnableClass implements Runnable {
		Reflector reflector;
		public RunnableClass(Reflector reflector) {
			this.reflector = reflector;
		}
		@Override
		public void run() {
			long begin = System.currentTimeMillis();
			System.out.println(begin);
			for(int i = 0; i < 10; i++) {
				System.out.println(reflector.reflect(Thread.currentThread().getName()));
			}
			long end = System.currentTimeMillis();
			System.out.println(end + ":" + (end - begin));
		}
	}
	static class Int {
		int value;
		void add() {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			value++;
		}
	}
	static class Reflector {
		Random random = new Random();
		int count;
		int synchroCount;
		AtomicInteger atomicCount = new AtomicInteger(0);
		String atomicReflect(String str) {
			atomicCount.addAndGet(1);
			return reflect(str);
		}
		synchronized String synchronizedReflect(String str) {
			synchroCount++;
			return baseReflect(str);
		}
		String baseReflect(String str) {
			int sleep = random.nextInt() / 0xff_ff_ff;
			if(sleep < 0) sleep = -sleep;
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				return e.getMessage();
			}
			StringBuilder buffer = new StringBuilder();
			return buffer
					.append(Thread.currentThread().getName())
					.append(":")
					.append(str)
					.append(":")
					.append(sleep)
					.append(":")
					.append(count)
					.append(":")
					.append(synchroCount)
					.append(":")
					.append(atomicCount.get())
					.toString();
		}
		String reflect(String str) {
			if(random.nextBoolean()) {
				count ++;
				return baseReflect(str);
			} else {
				count ++;
				return synchronizedReflect(str);
			}
		}
		String reflect() {
			return reflect("NONAME");
		}
	}
	//Threadクラスを継承する方法は使うべきでない
	static class ThreadClass extends Thread {
		@Override
		public void run() {
			System.out.println("test");
		}
	}
}
