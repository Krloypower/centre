package code.reactor.flux;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;

/**
 * @ClassName FluxExample
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/9/11
 * @Version 1.0
 **/
public class FluxExample {

    public static void main(String[] args) {
//        simple();
        generate();
//        create();
    }

    public static void simple(){
        Flux.just("Hello", "World").subscribe(System.out::println);
        Flux.fromArray(new Integer[] {1, 2, 3}).subscribe(System.out::println);
        Flux.empty().subscribe(System.out::println);
        Flux.range(1, 10).subscribe(System.out::println);
        Flux.interval(Duration.of(10, ChronoUnit.SECONDS)).subscribe(System.out::println);
        Flux.intervalMillis(1000).subscribe(System.out::println);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void generate(){
        Flux.generate(x->{
            x.next("Hello");
            x.complete();
        }).subscribe(x-> System.out.println(x));

        final Random random = new Random();
        Flux.generate(ArrayList::new, (x,y)->{
            int nextInt = random.nextInt(100);
            x.add(nextInt);
            y.next(x);
            if (x.size() == 10){
                y.complete();
            }
            return x;
        }).subscribe(x-> System.out.println(x));
    }

    public static void create(){
        Flux.create(x->{
            for (int i = 0 ; i< 10 ;i++){
                x.next(i);
            }
            x.complete();
        }).subscribe(x-> System.out.println(x));
    }
}
