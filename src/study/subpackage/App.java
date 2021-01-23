package site.saishin.study.java8.subpackage;
import site.saishin.study.java8.EnclosingClass;
//packageだけでなくエンクロージングクラスも含める
import site.saishin.study.java8.EnclosingClass.InnerClass;

public class App {

	public static void main(String[] args) {
		EnclosingClass enclosing = new EnclosingClass();
		//Enclosingクラスがインスタンス化されて初めてInnerクラスがインスタンス化される
		//EnclosingインスタンスとInnerインスタンスは結び付いている
		InnerClass inner = enclosing.createInner();
		inner.test();
	}
	//publicな内部クラスをフィールドとして持てる
	InnerClass inner;
}
