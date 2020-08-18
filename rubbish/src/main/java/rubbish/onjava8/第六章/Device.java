package rubbish.onjava8.第六章;

/**
 * @ClassName Device
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-26 10:35
 **/
public class Device extends Base {
    static int a = 1;
    static {
        System.out.println("Device static");
    }

    {
        System.out.println("Device {}");
    }

    public Device(){
        System.out.println("Device ()");
    }

    public static void main(String[] args) {
        Base.A();
        new Device();
    }


}
