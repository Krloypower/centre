package rubbish.onjava8.local;

import java.util.Optional;

/**
 * @ClassName OptionalDemo
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/4/21
 * @Version 1.0
 **/
public class OptionalDemo {
    public static void main(String[] args) {
        String a = null;
        Optional<String> optionalS = Optional.ofNullable(a).map(x -> x.toLowerCase());
        System.out.println(optionalS.isPresent());
        System.out.println(optionalS.get());
    }
}
