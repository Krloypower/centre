package rubbish.onjava8.local;

import org.apache.poi.ss.usermodel.DateUtil;
import org.omg.SendingContext.RunTime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName LocalTest
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/3/2
 * @Version 1.0
 **/
public class LocalTest {
    public static void main(String[] args) {
//        LocalDate today = LocalDate.now();
//        int value = today.getDayOfMonth();
//        int i = today.getMonth().length(today.isLeapYear()) - value;
//        System.out.println(i);
//
//        int i1 = Runtime.getRuntime().availableProcessors();
//        System.out.println(i1);



        LocalDateTime of = LocalDateTime.of(2021, 3, 10, 4, 10, 21);
        LocalDateTime dateTime = LocalDateTime.of(2021, 3, 9, 4, 10, 20);

        Duration between = Duration.between(dateTime, of);
        long l = between.toMillis();

        if ( l% 86400000 == 0){
            System.out.println(l / 86400000);
        }else {
            System.out.println(l / 86400000 + 1);
        }




    }



}
