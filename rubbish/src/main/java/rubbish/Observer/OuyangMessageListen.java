package rubbish.Observer;

/**
 * @ClassName OuyangMessageListen
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/9/21
 * @Version 1.0
 **/
public class OuyangMessageListen implements MessageListen<MessageEvent> {
    @Override
    public void onMessageEvent(MessageEvent var) {
        Message message = var.getMessage();
        String content = message.getContent();
        System.out.println("ouyang:"+ content);
    }
}
