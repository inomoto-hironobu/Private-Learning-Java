package study.stdlib.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StudyStream {

	public static void main(String... args) {
		//
		IntStream intStream;
		java.util.stream.IntStream.Builder intStreamBuilder = IntStream.builder();
		for(int i = 0; i < 100; i++) {
			intStreamBuilder.add(i);
		}
		intStream = intStreamBuilder.build();
		long count = intStream
		.filter(v -> v % 2 == 0)
		.count();
		System.out.println(count);

		IntStream.rangeClosed(1, 40)
				.filter(val -> {
					if(val % 15 == 0) {
						System.out.print("FizzBuzz");
						System.out.print(",");
						return false;
					}
					return true;
				}).filter(val -> {
			if(val % 5 == 0) {
				System.out.print("Buzz");
				System.out.print(",");
				return false;
			}
			return true;
		}).filter(val -> {
			if(val % 3 == 0) {
				System.out.print("Fizz");
				System.out.print(",");
				return false;
			}
			return true;
		}).filter(val -> {
			System.out.print(val);
			System.out.print(",");
			return false;
		}).count();
		
		java.util.stream.Stream.Builder<String> builder = Stream.builder();
		for(int i = 0; i < 100; i++) {
			
		}

	}
}
