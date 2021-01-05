package rubbish.onjava8.第十一章;

/**
 * @ClassName ClassLoadProcess
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/20
 * @Version 1.0
 **/
class Partent {

    {
        System.out.println("partent");
    }


    private String test = test();

    public Partent() {
        System.out.println("public Partent");
    }

//    private static Partent partent = new Partent();

    static {
        System.out.println("partent static");
    }



    public String test() {
        System.out.println("void test");
        return "test";
    }
}

public class ClassLoadProcess extends Partent {

//    private static ClassLoadProcess ClassLoadProcess = new ClassLoadProcess();

    static {
        System.out.println("ClassLoadProcess static");
    }

    {
        System.out.println("ClassLoadProcess");
    }

    private String test2 = test2();

    public ClassLoadProcess() {
        System.out.println("public ClassLoadProcess");
    }

    public String test2() {
        System.out.println("void test2");
        return "test2";
    }

    public static void main(String[] args) {
        Partent partent = new ClassLoadProcess();
    }
}
