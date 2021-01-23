package site.saishin.study.java8.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalClasss {

	public static void main(String[] args) {
		String string = "string";
        Consumer<String> consumer = (arg) -> {
        	//string = "string2";これはエラーになる
        	System.out.println(arg);
        };
        consumer.accept("Consumer#accept(String)");
        
        Supplier<String> supplier = () -> "Supplier";
        System.out.println(supplier.get());
        
        Function<String, String> function = (arg) -> arg + "test";
        System.out.println(function.apply("hoge"));
        
        Predicate<String> predicate = (arg) -> arg.equals("test");
        System.out.println(predicate.test("test"));
	}

}
