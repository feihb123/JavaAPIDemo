package cn.datacharm.concurrent;

import java.util.concurrent.Callable;

/**
 * description:
 * 使用callable创建线程，只能用过线程池启动
 * @author Herb
 * @date 2019/09/20
 */
public class CallableDemo implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Callable run!");
        return "Success!";
    }
}
