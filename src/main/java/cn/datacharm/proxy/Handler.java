package cn.datacharm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * description:
 * 实现InvocationHandler以进行动态代理
 * @author Herb
 * @date 2019/08/15
 */
public class Handler implements InvocationHandler {
    //动态代理类只能代理接口（不支持抽象类）
    //代理类都需要实现InvocationHandler类，实现invoke方法
    //该invoke方法就是调用被代理接口的所有方法时需要调用的
    // 该invoke方法返回的值是被代理接口的一个实现类

    Consume consumer;

    public Handler(Consume consumer) {
        this.consumer = consumer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("prepare...");
        method.invoke(consumer, args);
        System.out.println("complete!");
        return null;
    }
}
