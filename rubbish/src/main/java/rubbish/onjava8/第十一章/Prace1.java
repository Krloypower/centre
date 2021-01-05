package rubbish.onjava8.第十一章;

import sun.security.krb5.internal.crypto.Des;

/**
 * @ClassName Prace1
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/19
 * @Version 1.0
 **/
public class Prace1 {
    class Contants {
        private int i = 11;

        private int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

    public void ship(String dest){
        Contants contants = new Contants();
        Destination destination = new Destination(dest);
        System.out.println(destination.readLabel());

    }


    public static void main(String[] args) {
        Prace1 prace1 = new Prace1();
        prace1.ship("aaa");
    }
}
