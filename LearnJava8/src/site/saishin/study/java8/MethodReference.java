package site.saishin.study.java8;

import java.util.function.Consumer;

public class MethodReference {

	public static void main(String[] args) {
		SampleI s = MethodReference::test;
		s.fimethod();
		Consumer<String> c = Sample::test;
		SampleI2 s2 = Sample::test;
		SampleI3 s3 = StringBuilder::new;
		StringBuilder strBuff = s3.fimethod(10);
		SampleI4 s4 = new MethodReference()::toString;
		s4.method();
		SampleI5 s5 = System.out::println;
		MethodReference mr = new MethodReference();
	}

	public MethodReference() {
		Inner inner = new Inner();
	}
	class Inner {
		void method(String s) {
			
		}
	}
	static class Sample {
		static void test(String s) {
			
		}
	}
	static void test() {
		
	}
	void method() {
		Inner inner = new Inner();
		Consumer<String> s = inner::method;
		System.out.println("exec method");
	}
	@Override
	public String toString() {
		return "MethodReference";
	}
	@FunctionalInterface
	interface SampleI {
		void fimethod();
	}
	@FunctionalInterface
	interface SampleI2 {
		void fimethod(String s);
	}
	@FunctionalInterface
	interface SampleI3 {
		StringBuilder fimethod(int cap);
	}
	@FunctionalInterface
	interface SampleI4 {
		String method();
	}
	@FunctionalInterface
	interface SampleI5 {
		void method(String s);
	}
}
