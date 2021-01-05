package rubbish.onjava8.第十一章;

/**
 * @ClassName SequenceMain
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/19
 * @Version 1.0
 **/
public class SequenceMain {
    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i< 10; i++){
            sequence.add(i);
        }
        Selector selector = sequence.selector();
        while (selector.hasNext()){
            System.out.println(selector.next());
        }
    }
}
