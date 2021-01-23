package study.lang;

import java.util.Arrays;

public class SubClass extends BaseClass {
	int privateField;
	int packagePrivateField;
	protected int protectedField;
	
	SubClass(int privateField, int packagePrivateField, int protectedField) {
		super(100 + privateField, 100 + packagePrivateField, 100 + protectedField);
		this.privateField = privateField;
		this.packagePrivateField = packagePrivateField;
		this.protectedField = protectedField;
		//スーパークラスのprivateフィールドにはアクセスできない
		//super.privateField = privateField;
	}
	
	@Override
	void test() {
		System.out.println("SubClass#test()");
	}
	
	public int getPrivateField() {
		return privateField;
	}

	public int getPackagePrivateField() {
		return packagePrivateField;
	}

	public int getProtectedField() {
		return protectedField;
	}

	int get() {
		//スーパークラスのprivateフィールドにはアクセスできない
		//return super.privateField;
		return 0;
	}
	int getSupersPackagePrivateField() {
		//同じパッケージなのでアクセスできる
		return super.packagePrivateField;
	}
	int getSupersProtectedPrivateField() {
		//別のパッケージでもアクセスできる
		return super.protectedField;
	}
	public static void main(String[] args) {
		BaseClass superClass = new BaseClass(1,2,3);
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
		BaseClass superClass2 = new SubClass(4,5,6);
		//型はSuperClassだが実行結果はSubClassクラスのメソッドが実行される
		superClass2.test();
	}
}