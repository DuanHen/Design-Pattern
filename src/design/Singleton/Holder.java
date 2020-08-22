package design.Singleton;

//静态内部类
public class Holder {

    private Holder(){

    }
    public static Holder getInstance(){
        return InnerClass.Holder;
    }
    public static class InnerClass{
        private static final Holder Holder = new Holder();
    }
}
