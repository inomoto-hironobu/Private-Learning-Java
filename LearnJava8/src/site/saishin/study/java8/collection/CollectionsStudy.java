package site.saishin.study.java8.collection;

import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;

public class CollectionsStudy {
	public static void main(String...args) {
		HashMap<String,String> map = new HashMap<>();
		map.put("test","value");
		map.forEach(new BiConsumer<String, String>() {
			@Override
			public void accept(String s, String s2) {
				System.out.println(s);
				System.out.println(s2);
			}
		});
		map.forEach((String s, String s2)->{
			System.out.println(s);
			System.out.println(s2);
		});
	}
}
