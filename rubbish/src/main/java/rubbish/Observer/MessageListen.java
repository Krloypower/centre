package rubbish.Observer;

import java.util.EventListener;

/**
 * @ClassName MessageListen
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/9/21
 * @Version 1.0
 **/
public interface MessageListen<E extends MessageEvent>  extends EventListener {

    /**
     * @param var: 内容
     * @Author ouyangkang
     * @Description 订阅者订阅的东西
     * @Date 2020/9/21
     * @return: void
     **/
    void onMessageEvent(E var);
}
