package cn.datacharm.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * description:
 *
 * @author Herb
 * @date 2019/09/2019-09-19
 */
public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocketChannel server = ServerSocketChannel.open();
        //监听端口
        server.bind(new InetSocketAddress(8090));
        //设置为非阻塞
        server.configureBlocking(false);

        SocketChannel client = server.accept();
        while (client == null) {
            client = server.accept();
            Thread.sleep(100);
        }
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        client.read(buffer);
        buffer.flip();
        byte[] data = buffer.array();
        System.out.println(new String(data,0,buffer.limit()));

        client.close();

    }
}
