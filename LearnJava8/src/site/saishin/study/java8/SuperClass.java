package site.saishin.study.java8;

import java.util.Arrays;

//extends Object入らない。暗黙的にObjectクラスを継承している。明示しても良いが必要性はなく省略すべき。
public class SuperClass extends Object {

	public static void main(String[] args) {
		SuperClass superClass = new SuperClass(1,2,3);
		superClass.test();
		System.out.println(Arrays.toString(superClass.getFields()));
		//
		SubClass subClass = new SubClass(1,2,3);
		subClass.test();
		System.out.println(subClass.privateField);
		System.out.println(subClass.packagePrivateField);
		System.out.println(subClass.protectedField);
		System.out.println(Arrays.toString(subClass.getFields()));
		//サブクラスは基底クラスの型として変数定義できる
		SuperClass superClass2 = new SubClass(4,5,6);
		//型はSuperClassだが実行結果はSubClassクラスのメソッドが実行される
		superClass2.test();
	}
	private int privateField;
	int packagePrivateField;
	protected int protectedField;
	public SuperClass() {
		
	}
	public SuperClass(int privateField, int packagePrivateField, int protectedField) {
		this.privateField = privateField;
		this.packagePrivateField = packagePrivateField;
		this.protectedField = protectedField;
	}
	void test() {
		System.out.println("SuperClass#test()");
	}
	int[] getFields() {
		int[] arr = new int[3];
		arr[0] = privateField;
		arr[1] = packagePrivateField;
		arr[2] = protectedField;
		return arr;
	}
}
