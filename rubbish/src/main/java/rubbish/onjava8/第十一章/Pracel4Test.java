package rubbish.onjava8.第十一章;

/**
 * @ClassName Pracel4Test
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/19
 * @Version 1.0
 **/
public class Pracel4Test {
    public static void main(String[] args) {
        Pracel4 pracel4 = new Pracel4();
        Content content = pracel4.getContent();
        System.out.println(content.value());

        Destiation aaaaa = pracel4.getDestination("aaaaa");
        System.out.println(aaaaa.readLabel());


        Pracel4.Temp temp = pracel4.getTemp();
        System.out.println(temp.get());


    }
}
