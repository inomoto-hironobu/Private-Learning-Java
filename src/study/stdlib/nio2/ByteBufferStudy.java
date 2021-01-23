package study.stdlib.nio2;

import java.nio.ByteBuffer;

public class ByteBufferStudy {

	public static void main(String...args) {
		byte[] array = new byte[100];
		ByteBuffer buffer = ByteBuffer.allocate(100);
		buffer.putInt(1).flip();
		int i = buffer.getInt();
		Integer.toString(i, 16);

		byte[] barr = buffer.array();
		barr[0] = 2;
		System.out.println(buffer.get());
		System.out.println(buffer.get());
		barr[1] = 1;
		barr[2] = 4;
		System.out.println(buffer.get());
	}
}
