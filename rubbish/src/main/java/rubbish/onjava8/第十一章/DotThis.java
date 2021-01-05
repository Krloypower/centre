package rubbish.onjava8.第十一章;

/**
 * @ClassName DotThis
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/19
 * @Version 1.0
 **/
public class DotThis {

    public void f(){
        System.out.println("DotThis.f()");
    }

    public class Inner{
        public DotThis getDotThis(){
            return DotThis.this;
        }
    }

    public static void main(String[] args) {
        DotThis dotThis = new DotThis();
        DotThis.Inner inner = dotThis.new Inner();
        inner.getDotThis().f();
    }
}
