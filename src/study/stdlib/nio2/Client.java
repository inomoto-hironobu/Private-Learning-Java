package study.stdlib.nio2;

import study.stdlib.net.Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    byte[] bs = new byte[16];
    Server server;
    int port = 11451;
    InetSocketAddress v6 = new InetSocketAddress("::1", port);
    InetSocketAddress v4 = new InetSocketAddress("127.0.0.1", port);
    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client();

        client.server = server;
        client.run();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("send v4");
            SocketChannel.open(server.localv4).bind(client.v4).finishConnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("send v6");
            SocketChannel.open(server.localv6).bind(client.v6).finishConnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void run() {
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(() -> {
            System.out.println("::1");
            ByteBuffer b = ByteBuffer.allocate(1000);
            try {
                DatagramChannel datagramChannel = DatagramChannel.open();
                SocketAddress addr = datagramChannel.bind(v6).receive(b);
                System.out.println(addr.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        es.execute(() -> {
            System.out.println("127");
            ByteBuffer b = ByteBuffer.allocate(1000);
            try {
                DatagramChannel datagramChannel = DatagramChannel.open();
                SocketAddress addr = datagramChannel.bind(v4).receive(b);
                System.out.println(addr.toString());
                b.get(bs);
                System.out.println(Arrays.toString(bs));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        es.shutdown();
    }
}
