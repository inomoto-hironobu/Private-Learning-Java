package site.saishin.study.java8.lambda;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;


public class IntFunctionalClass
{
	int i;
    public static void main( String... args )
    {
        IntFunctionalClass functionalClass = new IntFunctionalClass();
        functionalClass.i = 10;
        
        IntConsumer intConsumer = (arg) -> System.out.println(arg + functionalClass.i);
        intConsumer.accept(10);
        intConsumer
        .andThen((arg) -> {functionalClass.i += arg;})
        .accept(10);
        System.out.println(functionalClass.i);
        
        IntSupplier intSupplier = () -> functionalClass.i;
        System.out.println(intSupplier.getAsInt());
        
        IntPredicate intPredicate = (arg) -> arg > 0;
        System.out.println(intPredicate.test(0));
        System.out.println(intPredicate.test(1));
        
        IntFunction<String> intFunction = (arg) -> Integer.toString(arg);
        System.out.println(intFunction.apply(10).length());
        
        int[] result = IntStream.rangeClosed(1, 40)
        .filter((v)->v % 2 == 0)
        .filter((v)->v % 3 == 0)
        .toArray();
        System.out.println(Arrays.toString(result));
        
    }
}
