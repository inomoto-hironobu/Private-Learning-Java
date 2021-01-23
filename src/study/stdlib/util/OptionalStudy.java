package study.stdlib.util;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalStudy {
	public static void main(String...strings) {
		boolean present;
		Optional<Integer> opt;
		Integer val;
		System.out.println("始まり");
		
		System.out.println("\n基本から");
		opt = Optional.of(11);
		opt.ifPresent(System.out::println);
		val = opt.get();
		System.out.println(val);
		val = opt.orElse(1);
		System.out.println(val);
		System.out.println("\n例外");
		try {
			opt = Optional.of(null);
		} catch (NullPointerException e) {
			System.err.println("null");
		}
		
		opt = Optional.ofNullable(null);
		System.out.println(opt.isPresent());
		try {
			val = opt.get();
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
		}
		
		opt = Optional.of(11);
		present = opt.filter(v -> v.intValue() > 10).isPresent();
		System.out.println(present);
		
		Long longval = opt.map(v -> Long.valueOf((long) v.intValue())).get();
		System.out.println(longval);
		
		present = opt.map(v -> null).isPresent();
		System.out.println(present);
	}
}
