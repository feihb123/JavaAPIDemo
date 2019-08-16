package cn.datacharm.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * description:
 * 实现MethodInterceptor使用cglib实现动态代理
 * @author Herb
 * @date 2019/08/15
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("prepare...");
        methodProxy.invokeSuper(o, objects);
        System.out.println("complete!");
        return null;
    }
}
