package site.saishin.study.java8;

public class EnclosingClass {

	Object field;
	//他のクラスからは操作できないが内部クラスからは操作できる
	private StringBuilder stringBuffer;
	
	public EnclosingClass() {
		stringBuffer = new StringBuilder();
	}
	public InnerClass createInner() {
		return new InnerClass();
	}
	public static void main(String... agrs) {
		EnclosingClass enclosing = new EnclosingClass();
		enclosing.createInner();
	}
	//
	public static class StaticInnerClass {
		
	}
	/**
	 * 他のクラスからも利用可能
	 */
	public class InnerClass {
		
		public void test() {
			System.out.println("test");
			stringBuffer.append(true);
		}
		/**
		 * 内部クラスにさらに内部クラスを作れる
		 */
		public class InnerInner {
			
		}
	}
	class Inner2 {
		InnerClass inner;
		void test() {
			InnerClass inner = new InnerClass();
		}
	}
}
