package site.saishin.study.java8.nio;

import java.nio.ByteBuffer;

public class ByteBufferStudy {

	public static void main(String...args) {
		ByteBuffer b = ByteBuffer.wrap(new byte[100]);
		byte[] barr = b.array();
		barr[0] = 2;
		System.out.println(b.get());
		System.out.println(b.get());
		barr[1] = 1;
		barr[2] = 4;
		System.out.println(b.get());
	}
}
