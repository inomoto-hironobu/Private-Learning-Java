package site.saishin.study.java8.datetime;

import java.time.Instant;
import java.time.LocalDateTime;

public class Datetime {

	public static void main(String[] args) {
		System.out.println(Instant.now());
		System.out.println(Instant.now().getNano());
		LocalDateTime.now();
	}

}
