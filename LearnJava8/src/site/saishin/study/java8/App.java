package site.saishin.study.java8;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String... args) {
		new App().learn3();
	}

	void helloworld() {
		System.out.println("Hello World!");
	}

	void calc() {
		int a = 3;
		int b = 6;
		System.out.println(a + b);
	}

	// nullは何にでもキャストできる
	void learn3() {
		Number n = (Number) null;
		if (n == null) {
			System.out.println("null");
		}
	}

	// キャストの確認基底クラスへのキャストは問題ない
	void learn2() {
		Number n;
		Object o = Integer.valueOf(1);
		n = (Number) o;
		System.out.println(n);
	}

}
