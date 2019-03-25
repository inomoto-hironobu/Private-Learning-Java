package site.saishin.study.java8;

public class Enclosing {

	public static void main(String... agrs) {
		Enclosing enclosing = new Enclosing();
		enclosing.createInner();
	}
	public Enclosing() {
		stringBuffer = new StringBuilder();
	}
	public Inner createInner() {
		return new Inner();
	}
	Object field;
	//他のクラスからは操作できないが内部クラスからは操作できる
	private StringBuilder stringBuffer;
	/**
	 * 他のクラスからも利用可能
	 */
	public class Inner {
		
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
		Inner inner;
		void test() {
			Inner inner = new Inner();
		}
	}
}
