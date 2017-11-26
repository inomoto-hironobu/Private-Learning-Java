package site.saishin.study;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * Hello world!
 *
 */
public class Functional
{
    public static void main( String... args )
    {
        new Functional().learnSupplier();
    }

    void learnSupplier() {
        System.out.println(sample2(()->{return new StringBuilder("test");}).toString());
    }
    void learn2() {

    }

    CharSequence sample(Supplier<CharSequence> s) {
        return s.get();
    }
    <T> T sample2(Supplier<T> s) {
       return s.get();
    }
    void sample3(IntSupplier s) {
        s.getAsInt();
    }
}
