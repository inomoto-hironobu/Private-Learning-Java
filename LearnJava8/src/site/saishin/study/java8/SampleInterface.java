package site.saishin.study.java8;
/**
 * 
 */
public interface SampleInterface {
	default void test() {
		System.out.println("test");
	}
	static void staticMethod() {
		System.out.println("test");
	}
}
interface Test {
	
}