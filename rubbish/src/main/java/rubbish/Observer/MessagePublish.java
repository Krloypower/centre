package rubbish.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MessagePublish
 * @Description 发布者 大概的伪代码
 * @Author ouyangkang
 * @Date 2020/9/21
 * @Version 1.0
 **/
public class MessagePublish {
    List<MessageListen<MessageEvent>> listens = new ArrayList<>();

    public void add(MessageListen<MessageEvent> listen){
        listens.add(listen);
    }

    public void publish(MessageEvent messageEvent){
        for (MessageListen<MessageEvent> listen : listens){
            listen.onMessageEvent(messageEvent);
        }
    }
}
