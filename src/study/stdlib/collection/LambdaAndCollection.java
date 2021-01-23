package study.stdlib.collection;

import java.util.HashMap;
import java.util.function.BiConsumer;

/**
 * Hello world!
 *
 */
public class LambdaAndCollection
{
    public static void main( String... args )
    {
        new LambdaAndCollection().collection();
    }
    void helloworld() {
    	System.out.println( "Hello World!" );
    }
    void calc() {
        int a = 3;
        int b = 6;
        System.out.println(a + b);
    }
    void learn() {
        System.out.println("インタフェース匿名内部クラス");
        SampleFunctionalInterface sample1 = new SampleFunctionalInterface() {
            @Override
            public int singleMethod(CharSequence cs) {
                return cs.length();
            }
        };
        sampleInstanceMethod1(sample1);
        SampleFunctionalInterface sf = (cs) -> {return cs.length();};
    }
    void sampleInstanceMethod1(SampleFunctionalInterface sf) {
        int i = sf.singleMethod("test");
        System.out.println("result:" + i);
    }
    @FunctionalInterface
    interface SampleFunctionalInterface {
        int singleMethod(CharSequence cs);
    }
    void collection() {
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
