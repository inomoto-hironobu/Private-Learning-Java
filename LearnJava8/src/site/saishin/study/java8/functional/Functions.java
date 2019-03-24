package site.saishin.study.java8.functional;

import java.util.function.Consumer;

public class Functions {

	public static void main(String[] args) {
		Functions functions = new Functions();
		functions.test((c)->{});
	}

	private void test(Consumer<String> consumer) {
		consumer.accept("");
	}
}
