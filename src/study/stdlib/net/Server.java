package study.stdlib.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    int port = 11514;
    InetSocketAddress localv6 = new InetSocketAddress("::1",port);
    InetSocketAddress localv4 = new InetSocketAddress("127.0.0.1", port);
    final ByteBuffer bbufer = ByteBuffer.allocate(10000);
    public Server() {}
    public static void main(String[] args) {
        System.setProperty("java.net.preferIPv6Addresses","true");
        Server server = new Server();
        server.runTcp();
    }
    Runnable v4 =() -> {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(localv4);
            boolean move = true;
            while(move) {
                SocketChannel channel = serverSocketChannel.accept();
                System.out.println("accept");
                InetSocketAddress addr = (InetSocketAddress) channel.shutdownInput().getRemoteAddress();
                System.out.println(addr);
                bbufer.clear();
                bbufer.put(addr.getAddress().getAddress());
                send(addr, bbufer);
                channel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    };
    public void runTcp() {
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(() -> {
            try {
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.bind(localv6);
                boolean move = true;
                while(move) {
                    SocketChannel channel = serverSocketChannel.accept();
                    System.out.println("accept");
                    InetSocketAddress addr = (InetSocketAddress) channel.shutdownInput().getRemoteAddress();
                    System.out.println(addr);
                    bbufer.clear();
                    bbufer.put(addr.getAddress().getAddress());
                    send(addr, bbufer);
                    channel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        es.execute(v4);
        es.shutdown();
    }
    private void send(InetSocketAddress addr, ByteBuffer buffer) throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.bind(addr);
        datagramChannel.send(buffer, addr);
        datagramChannel.disconnect().close();
    }
}
