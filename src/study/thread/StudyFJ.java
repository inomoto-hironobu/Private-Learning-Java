package site.saishin.study.java8.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class StudyFJ {

	public static void main(String[] args) {
		ForkJoinPool pool = ForkJoinPool.commonPool();
		ForkJoinTask<Integer> task = new ForkJoinTask<Integer>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Integer getRawResult() {
				System.out.println("get");
				return 1;
			}

			@Override
			protected void setRawResult(Integer value) {
				System.out.println("set");
			}

			@Override
			protected boolean exec() {
				System.out.println("exec");
				return true;
			}
		};
		ForkJoinTask<Integer> t = pool.submit(task);
		Integer val = t.join();
		System.out.println(val);
	}
}
