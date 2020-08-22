package design.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

//懒汉式
public class LazyMan {

    private static boolean nicai = false;

    private LazyMan(){
        synchronized (LazyMan.class){
            if(nicai == false){
                nicai = true;
            }else {
                throw new RuntimeException("不要使用反射破坏异常");
            }
        }
    }
    private volatile static LazyMan LazyMan;
    public  static LazyMan getInstance(){
        if (LazyMan == null){
            synchronized (LazyMan.class){
                if (LazyMan == null){
                    LazyMan = new LazyMan();
                }
            }
        }
        return LazyMan;
    }

    //反射
    public static void main(String[] ages) throws Exception {
        //LazyMan instance = LazyMan.getInstance();//获得第一个对象
        Field nicai = LazyMan.class.getDeclaredField("nicai");
        nicai.setAccessible(true);
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);//获得空参构造器 抛出异常
        declaredConstructor.setAccessible(true);//暴力反射 无视私有构造器
        LazyMan instance = declaredConstructor.newInstance(); //通过反射创建一个对象
        nicai.set(instance,false);
        LazyMan instance2 = declaredConstructor.newInstance(); //通过反射创建一个对象
        System.out.println(instance); //理论上来说这俩应该相等
        System.out.println(instance2);
    }
}