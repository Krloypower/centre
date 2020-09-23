package rubbish.Observer;

/**
 * @ClassName Main
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/9/18
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        MessagePublish messagePublish = new MessagePublish();
        KangMessageListen kangMessageListen = new KangMessageListen();
        OuyangMessageListen ouyangMessageListen = new OuyangMessageListen();
        messagePublish.add(kangMessageListen);
        messagePublish.add(ouyangMessageListen);

        Message message = new Message();
        message.setContent("Hello");
        MessageEvent messageEvent = new MessageEvent(message);
        messagePublish.publish(messageEvent);

        message.setContent("Hi");
        MessageEvent messageEvent2 = new MessageEvent(message);
        messagePublish.publish(messageEvent2);
    }
}
