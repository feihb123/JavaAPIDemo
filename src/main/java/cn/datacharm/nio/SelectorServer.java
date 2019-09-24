package cn.datacharm.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * description:
 *
 * @author Herb
 * @date 2019/09/2019-09-19
 */
public class SelectorServer {
    public static void main(String[] args) throws IOException {

        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress(8090));
        server.configureBlocking(false);
        //开启选择器
        Selector selector = Selector.open();
        //将通道注册到选择器上
        server.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            //进行选择
            selector.select();
            // 获取当前选择器中所有注册的选择键（“已经准备就绪的操作”）
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> it = keys.iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                //可接受 可读 可写
                if (key.isAcceptable()) {
                    //从事件中将通道取出
                    ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                    SocketChannel sc = ssc.accept();
                    System.out.println("连接成功！");
                    sc.configureBlocking(false);
                    sc.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                }
                if (key.isReadable()) {
                    SocketChannel sc = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    sc.read(buffer);
                    byte[] array = buffer.array();
                    System.out.println(new String(array, 0, buffer.position()));
                    //注销掉read事件 防止重复读取

                    sc.register(selector, key.interestOps() ^ SelectionKey.OP_READ);
                }
                if (key.isWritable()) {
                    SocketChannel sc = (SocketChannel) key.channel();
                    sc.write(ByteBuffer.wrap("hello client".getBytes()));
                    sc.register(selector, key.interestOps() ^ SelectionKey.OP_WRITE);
                }
                it.remove();
            }
        }
    }
}
