package rubbish.onjava8.第十一章;

/**
 * @ClassName BigEgg
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/20
 * @Version 1.0
 **/
class Egg2 {
    protected class Yolk {
        public Yolk() {
            System.out.println("Egg2.Yolk()");
        }
        public void f() {
            System.out.println("Egg2.Yolk.f()");
        }
    }
    public Egg2() {
        System.out.println("New Egg2()");
    }
    private Yolk y = new Yolk();

    {
        System.out.println("aaa");
    }

    public void insertYolk(Yolk yy) { y = yy; }
    public void g() { y.f(); }
}
public class BigEgg extends Egg2 {

    private Yolk aa = new Yolk();

    public class Yolk extends Egg2.Yolk {
        public Yolk() {
            System.out.println("BigEgg2.Yolk()");
        }
        @Override
        public void f() {
            System.out.println("BigEgg2.Yolk.f()");
        }
    }
    public BigEgg() {
        insertYolk(new Yolk());
    }
    public static void main(String[] args) {
        Egg2 e2 = new BigEgg();
        e2.g();
    }
}
