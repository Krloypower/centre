package rubbish.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName Main
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-05-28 18:24
 **/
@Component
public class Main {

    @Cache(value = "cacheKang")
    public String test(){
        // do someThing
        return "kang";
    }
}
