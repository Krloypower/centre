package code.reactor.mono;

import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * @ClassName MonoExample
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/9/11
 * @Version 1.0
 **/
public class MonoExample {
    public static void main(String[] args) {
        simple();
    }

    public static void simple(){
        Mono.fromSupplier(()-> "hello").subscribe(x-> System.out.println(x));
        Mono.justOrEmpty(Optional.of("Hello")).subscribe(x-> System.out.println(x));
        Mono.create(x->x.success("aa")).subscribe(x-> System.out.println(x));
    }
}
