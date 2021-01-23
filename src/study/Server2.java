package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server2 {
    int port = 11111;
    InetSocketAddress localv6 = new InetSocketAddress("::1",port);
    InetSocketAddress local = new InetSocketAddress("::1", port + 1);
    ByteBuffer bbufer = ByteBuffer.allocate(10000);
    public static void main(String[] args) {
        System.setProperty("java.net.preferIPv6Addresses","true");
        Server2 server = new Server2();
        server.run();
    }

    Runnable v2 =() -> {
        try {
            SocketChannel channel = SocketChannel.open(new InetSocketAddress("::1", 11514)).shutdownInput();
            SocketAddress localAddress = channel.getLocalAddress();
            System.out.println(localAddress);
            channel.finishConnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    };
    Runnable v1 = () -> {
        try {
            DatagramChannel datagramChannel = DatagramChannel.open();
            SocketAddress addr = datagramChannel.bind(localv6).receive(bbufer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    };
    public void run() {
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(v2);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //es.execute(v1);

        es.shutdown();
    }
}
