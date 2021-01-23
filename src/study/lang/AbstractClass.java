package study.lang;

public abstract class AbstractClass {

	// mainメソッドを含め、static メソッドは書ける
	public static void main(String... args) {
		// これはできない
		// AbstractClass abstractClass = new AbstractClass();
		
		// これはできる 匿名内部クラス
		AbstractClass abstractClass = new AbstractClass() {
			@Override
			public void test() {
				System.out.println("test");
			}
		};
		
		//標準ライブラリから
		Number number = Integer.valueOf("1");
		
	}
	public abstract void test();
}
