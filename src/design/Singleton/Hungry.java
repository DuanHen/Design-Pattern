package design.Singleton;

//饿汉式单例

public class Hungry {

    //可能会浪费空间
    private byte[] data1 = new byte[1024*1024];
    private byte[] data2 = new byte[1024*1024];
    private byte[] data3 = new byte[1024*1024];
    private byte[] data4 = new byte[1024*1024];

    //懒汉式构造器私有化
    private Hungry (){
    }
    private final static Hungry  Hungry = new Hungry();

    public static Hungry getInstance(){
        return Hungry;
    }

}
