package site.saishin.study.java8.subpackage;
import site.saishin.study.java8.Enclosing;
//packageだけでなくエンクロージングクラスも含める
import site.saishin.study.java8.Enclosing.Inner;

public class App {

	public static void main(String[] args) {
		Enclosing enclosing = new Enclosing();
		//Enclosingクラスがインスタンス化されて初めてInnerクラスがインスタンス化される
		//EnclosingインスタンスとInnerインスタンスは結び付いている
		Inner inner = enclosing.createInner();
		inner.test();
	}
	//publicな内部クラスをフィールドとして持てる
	Inner inner;
}
