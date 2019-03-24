package site.saishin.study.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * Hello world!
 *
 */
public class Lambda
{
    public static void main( String... args )
    {
        new Lambda().learn4();
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
        execsfi4(匿名内部記法instance);

        //
        System.out.println("ラムダ記法インスタンス");
        SampleFunctionalInterface4 ラムダ記法instance = (cs) -> {return cs.length();};
        execsfi4(ラムダ記法instance);
        SampleFunctionalInterface4 ラムダ記法instance2 = cs -> cs.length();
        execsfi4(ラムダ記法instance2);

        //
        execsfi4(cs->cs.length());
    }
    private void execsfi4(SampleFunctionalInterface4 sf) {
        int i = sf.method("test");
        System.out.println("result:" + i);
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
        execsfi(匿名内部記法instance);
        //
        SampleFunctionalInterface ラムダ記法instance = () -> System.out.println("test");
        execsfi(ラムダ記法instance);
        //
        execsfi(()-> System.out.println("テスト"));
    }

	void learn3() {
		execsfi(() -> {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
				//例外が発生した場合はラムダ内で処理する
			}
		});
		
	}
    private void execsfi(SampleFunctionalInterface sfi) {
        sfi.method();
    }
	void learn4() {
		sample4(l->l = new ArrayList<>());
	}
	void sample4(Consumer<List<Integer>> cons) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		cons.accept(list);
		System.out.println(list.size());
	}
	void sample(SampleFunctionalInterface3<String> func) {
		try {
			func.method(null);
		} catch (Exception e) {
			e.printStackTrace();
			//チェック例外をキャッチ
		}
	}
    
    //@FunctionalInterfaceをつけるとラムダ式用のインターフェースとして強制されるようにチェックされる
    @FunctionalInterface
    interface SampleFunctionalInterface {
        void method();
    }
    @FunctionalInterface
    interface SampleFunctionalInterface2<T> {
        T method();
    }
    @FunctionalInterface
    interface SampleFunctionalInterface3<T> {
        void method(T t) throws Exception;
    }
    @FunctionalInterface
    interface SampleFunctionalInterface4 {
        int method(CharSequence cs);
    }

}
