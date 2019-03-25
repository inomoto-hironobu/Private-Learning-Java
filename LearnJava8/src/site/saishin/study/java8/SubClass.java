package site.saishin.study.java8;

public class SubClass extends SuperClass {
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
}