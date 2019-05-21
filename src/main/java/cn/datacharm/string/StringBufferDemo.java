package cn.datacharm.string;

/**
 * StringBuffer是可变字符串，多线程使用，线程安全
 * @author datacharm.cn
 */
public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("开始-");
        stringBuffer.append("1-");
        stringBuffer.append("2-");
        stringBuffer.append("3");
        System.out.println(stringBuffer);
    }
}
