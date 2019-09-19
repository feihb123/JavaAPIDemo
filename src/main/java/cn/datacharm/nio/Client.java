package cn.datacharm.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * description:
 * SocketChannel
 * @author Herb
 * @date 2019/09/2019-09-19
 */
public class Client {
    public static void main(String[] args) throws  Exception{
        //创建一个客户端通道
        SocketChannel client = SocketChannel.open();
        // 配置通道为非阻塞
        client.configureBlocking(false);
        //发起连接
        client.connect(new InetSocketAddress("localhost",8090));
        //因为设置非阻塞，需要保证建立了连接才能写数据
        while (!client.isConnected()) {
            //方法会自动计数，多次未连接上 会任务连接无法建立
            client.finishConnect();
        }

        //写入数据
        client.write(ByteBuffer.wrap("hello!".getBytes()));

        client.close();


    }
}
