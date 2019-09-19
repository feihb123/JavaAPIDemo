package cn.datacharm.nio;

import java.nio.ByteBuffer;

/**
 * description:
 * ByteBufferDemo
 * @author Herb
 * @date 2019/09/2019-09-19
 */
public class ByteBufferDemo {
    public static void main(String[] args) {
        //ByteBuffer底层基于 字节数组 即allocate 需要指定容量
        ByteBuffer buffer = ByteBuffer.allocate(10);
        //添加数据
        buffer.put("xbb".getBytes());
        buffer.put("xjj".getBytes());

        //如果要遍历缓冲区 先要把Limit挪到position上然后将Position归零
        /*buffer.limit(buffer.position());
        buffer.position(0);*/
        //翻转缓冲区 相当于上面两步操作
        buffer.flip();
        while (buffer.position() < buffer.limit()) {
            System.out.println(buffer.get());
        }
        //相当于上面循环
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
        //需要将position移动到指定位置
        //buffer.position(0);
        //获取数据 【一个字节】
        //byte b = buffer.get();
        //System.out.println(b);


    }
}
