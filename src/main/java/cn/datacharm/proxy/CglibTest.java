package cn.datacharm.proxy;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

/**
 * description:
 * cglib动态代理测试类
 * CGLIB实现动态代理的原理是生成的动态代理是被代理者的子类，
 * 所以代理者具有和父类即被代理者 相同的方法，从而实现代理。
 * @author Herb
 * @date 2019/08/15
 */
public class CglibTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        // 设定父类 -- 此处要传入被代理者的类，
        // cglib是通过集成被代理者的类来持有和被代理者相同的方法的，此方法必须设置
        enhancer.setSuperclass(Consumer.class);
        // 设定回调函数 -- 为增强器设定回调函数，
        // 之后通过增强器生成的代理对象调用任何方法都会走到此回调函数中，实现调用真正被代理对象的方法的效果
        enhancer.setCallback(new MyMethodInterceptor());
        Consumer consumer = (Consumer) enhancer.create();
        consumer.buy();
    }
}
