package code.reactor.flux;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;

/**
 * @ClassName operation
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/9/11
 * @Version 1.0
 **/
public class Operation {

    public static void main(String[] args) throws Exception {
//        Flux.range(1, 100).buffer(20).subscribe(System.out::println);
//        Flux.range(1, 10).bufferUntil(i -> i % 2 == 0).subscribe(System.out::println);
//        Flux.range(1, 10).bufferWhile(i -> i % 2 == 0).subscribe(System.out::println);
//        Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);
//        Flux.range(1, 100).window(20).subscribe(x->x.subscribe(System.out::println));

//        Flux.just("a", "b")
//                .zipWith(Flux.just("c", "d"))
//                .subscribe(System.out::println);
//        Flux.just("a", "b")
//                .zipWith(Flux.just("c", "d"), (s1, s2) -> String.format("%s-%s", s1, s2))
//                .subscribe(System.out::println);

//        Flux.range(1, 1000).take(10).subscribe(System.out::println);
//        Flux.range(1, 1000).takeLast(10).subscribe(System.out::println);
//        Flux.range(1, 1000).takeWhile(i -> i < 10).subscribe(System.out::println);
//        Flux.range(1, 1000).takeUntil(i -> i == 10).subscribe(System.out::println);


//        Flux.range(1, 10).reduce((x, y) -> x + y).subscribe(System.out::println);
//        Flux.range(1, 10).reduceWith(() -> 1, (x, y) -> x + y).subscribe(System.out::println);

//
//        Flux.merge(Flux.intervalMillis(0, 100).take(5), Flux.intervalMillis(50, 100).take(5))
//                .toStream()
//                .forEach(System.out::println);
//        Flux.mergeSequential(Flux.intervalMillis(0, 100).take(5), Flux.intervalMillis(50, 100).take(5))
//                .toStream()
//                .forEach(System.out::println);


//
//        Flux.just(5, 10)
//                .flatMapSequential(x -> Flux.intervalMillis(x * 10, 100).take(x))
//                .toStream()
//                .forEach(System.out::println);
//
//        Flux.create((t) -> {
//            t.next("create");
//            t.next("create1");
//            t.complete();
//        }).subscribe(System.out::println);

//        Flux.from(Flux.just("1","2","3")).subscribe(System.out::println);
//        Flux.just("1","2","3").subscribe(System.out::println);

//        Flux.combineLatest(
//                Arrays::toString,
//                Flux.intervalMillis(100).take(5),
//                Flux.intervalMillis(50, 100).take(5)
//        ).toStream().forEach(System.out::println);
//        final Flux<Long> source = Flux.intervalMillis(1000)
//                .take(10)
//                .publish()
//                .autoConnect();
//        source.subscribe();
//        Thread.sleep(5000);
//        source
//                .toStream()
//                .forEach(System.out::println);

    }
}
