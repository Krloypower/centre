package rubbish.onjava8.第十一章;

/**
 * @ClassName Prace5
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/19
 * @Version 1.0
 **/
public class Prace5 {

    public Destiation destiation(String s) {
        class PDestination implements Destiation {

            private String s;

            PDestination(String s) {
                this.s = s;
            }

            @Override
            public String readLabel() {
                return s;
            }
        }
        return new PDestination(s);
    }

    public Destiation destiation2(String s) {
        return () -> s;
    }

    public Content2 content2(String s) {
        return (x) -> {
            return x + s;
        };
    }

    public static void main(String[] args) {
        Prace5 prace5 = new Prace5();
        Content2 content2 = prace5.content2("kang");
        String ouyang = content2.readLabel("ouyang ");
        System.out.println(ouyang);

    }
}
