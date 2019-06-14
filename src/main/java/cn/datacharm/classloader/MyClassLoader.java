package cn.datacharm.classloader;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class TestClassLoad {
    @Override
    public String toString() {
        return "类加载成功。";
    }
}
public class MyClassLoader extends ClassLoader {
    private String classPath;

    public MyClassLoader() {
    }

    public MyClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] getData(String className) {
        String path = classPath + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
        try {
            InputStream is = new FileInputStream(path);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int num = 0;
            while ((num = is.read(buffer)) != -1) {
                stream.write(buffer, 0, num);
            }
            return stream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }



    public static void main(String args[]) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        ClassLoader classLoader= new MyClassLoader("F:\\Workplace\\Demo\\target\\classes\\bin");
        //注意要包括包名  - >  加载自己
        Class c1 = classLoader.loadClass("cn.datacharm.classloader.MyClassLoader");
        System.out.println(c1.newInstance());
        //加载其他类
        Class c2 = classLoader.loadClass("cn.datacharm.classloader.TestClassLoad");
        System.out.println(c2.newInstance());
    }
}
