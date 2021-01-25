package code.number;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

/**
 * @ClassName BitMapTest
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/19
 * @Version 1.0
 **/
public class BitMapTest {

    public static void main(String[] args) {
        Random random = new Random();
        int count = 100;
        List<Integer> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt(count));
        }
        System.out.println("产生的随机数有:"+ list);
        BitSet bit = new BitSet(count);
        for (int i = 0; i< count; i++){
            bit.set(list.get(i));
        }

        System.out.println("不存在的随机数有：");
        for (int i = 0; i< count; i++){
            if (!bit.get(i)){
                System.out.print(i + "，");
            }
        }
    }
}
