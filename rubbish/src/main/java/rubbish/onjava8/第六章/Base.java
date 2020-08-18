package rubbish.onjava8.第六章;

/**
 * @ClassName Base
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-26 10:34
 **/
public class Base {
    static {
        System.out.println("base static");
    }

    {
        System.out.println("base {}");
    }

    public Base(){
        System.out.println("base Base()");
    }
    public  static void A(){
        int a;
        System.out.println("base A()");
    }
}
