package site.saishin.study;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.function.BiConsumer;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String... args )
    {
        new App().learn3();
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
    //nullは何にでもキャストできる
    void learn3() {
    	Number n = (Number) null;
    	if(n == null) {
    		System.out.println("null");
    	}
    }
    //キャストの確認基底クラスへのキャストは問題ない
    void learn2() {
    	Number n;
    	Object o = Integer.valueOf(1);
    	n = (Number) o;
    	System.out.println(n);
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
