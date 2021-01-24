package study.lang;
/**
 * 
 */
public interface SampleInterface {
	// default メソッド
	default void defaultMethod() {
		System.out.println("test");
	}
	// static メソッド
	static void staticMethod() {
		System.out.println("test");
	}
	//
	void method();
	
}