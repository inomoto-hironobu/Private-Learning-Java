package site.saishin.study.java8.generics;

import java.util.HashMap;
import java.util.HashSet;

public class App {

	public static void main(String[] args) {
		GenericsClass<Integer> genericsClass = new GenericsClass<>();
		//null
		System.out.println(genericsClass.get());
		genericsClass.set(1);
		//Integerの1
		System.out.println(genericsClass.get());
		
		ImplementsGenericsClass<String> implementsGenericsClass = new ImplementsGenericsClass<>();
		
		//標準ライブラリからコレクション
		HashSet<Double> doubleSet = new HashSet<>();
		HashMap<String, Integer> map = new HashMap<>();
	}

	static class GenericsClass<T> {
		T t;
		void set(T t) {
			this.t = t;
		}
		T get() {
			return t;
		}
	}
	interface GenericsInterface<T> {
		T get();
	}
	/**
	 * ジェネリクスを持つインターフェイスを実装したクラス
	 */
	static class ImplementsGenericsClass<T> implements GenericsInterface<T> {
		T t;
		void set(T t) {
			this.t = t;
		}
		@Override
		public T get() {
			return t;
		}
		
	}
	static class ImplementsClass2 implements GenericsInterface<String> {
		@Override
		public String get() {
			return "Test";
		}
	}
}
