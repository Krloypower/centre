package rubbish.onjava8.local;

import org.omg.SendingContext.RunTime;

import java.time.LocalDate;

/**
 * @ClassName LocalTest
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/3/2
 * @Version 1.0
 **/
public class LocalTest {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        int value = today.getDayOfMonth();
        int i = today.getMonth().length(today.isLeapYear()) - value;
        System.out.println(i);

        int i1 = Runtime.getRuntime().availableProcessors();
        System.out.println(i1);


    }

}
