package cn.datacharm.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Herb
 * @Description: JDK中提供的动态代理方式
 * @date 2019/08/15
 */
public class JavaProxyDemoTest {
    @Test
    public void test() {
        Consume consumer = new Consumer();
        Handler handler = new Handler(consumer);
        Consume consumer2 = (Consume) Proxy.newProxyInstance(Consumer.class.getClassLoader(), Consumer.class.getInterfaces(), handler);
        consumer2.buy();
    }
}
