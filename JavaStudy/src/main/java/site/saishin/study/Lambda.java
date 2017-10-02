package site.saishin.study;

/**
 * Hello world!
 *
 */
public class Lambda
{
    public static void main( String... args )
    {
        new Lambda().learn();
    }

    void learn() {
        //
        System.out.println("インタフェース匿名内部クラス");
        SampleFunctionalInterface4 匿名内部記法instance = new SampleFunctionalInterface4() {
            @Override
            public int method(CharSequence cs) {
                return cs.length();
            }
        };
        sampleInstanceMethod1(匿名内部記法instance);

        //
        System.out.println("ラムダ記法インスタンス");
        SampleFunctionalInterface4 ラムダ記法instance = (cs) -> {return cs.length();};
        sampleInstanceMethod1(ラムダ記法instance);
        SampleFunctionalInterface4 ラムダ記法instance2 = cs -> cs.length();
        sampleInstanceMethod1(ラムダ記法instance2);

        //
        sampleInstanceMethod1(cs->cs.length());
    }
    void learn2() {
        //
        System.out.println("インタフェース匿名内部クラス");
        SampleFunctionalInterface 匿名内部記法instance = new SampleFunctionalInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部クラス");
            }
        };
        sample(匿名内部記法instance);
        //
        SampleFunctionalInterface ラムダ記法instance = () -> System.out.println("test");
        sample(ラムダ記法instance);
        //
        sample(()-> System.out.println("テスト"));
    }

    void sample(SampleFunctionalInterface sfi) {
        sfi.method();
    }
    void sampleInstanceMethod1(SampleFunctionalInterface4 sf) {
        int i = sf.method("test");
        System.out.println("result:" + i);
    }
    //@FunctionalInterfaceをつけるとラムダ式用のインターフェースとして強制されるようにチェックされる
    @FunctionalInterface
    interface SampleFunctionalInterface {
        void method();
    }
    @FunctionalInterface
    interface SampleFunctionalInterface4 {
        int method(CharSequence cs);
    }
    @FunctionalInterface
    interface SampleFunctionalInterface2<T> {
        T method();
    }
    @FunctionalInterface
    interface SampleFunctionalInterface3<T> {
        void method(T t);
    }
}
