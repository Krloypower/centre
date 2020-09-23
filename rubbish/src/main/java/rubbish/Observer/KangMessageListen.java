package rubbish.Observer;

/**
 * @ClassName KangMessageListen
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/9/21
 * @Version 1.0
 **/
public class KangMessageListen implements MessageListen<MessageEvent> {
    private String content;

    @Override
    public void onMessageEvent(MessageEvent var) {
        Message message = var.getMessage();
        content = message.getContent();
        doSomeThing();
    }


    public void doSomeThing(){
        System.out.println("kang :" + content);
    }

}
