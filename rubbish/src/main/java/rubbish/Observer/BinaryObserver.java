package rubbish.Observer;

/**
 * @ClassName BinaryObserver
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/9/18
 * @Version 1.0
 **/
public class BinaryObserver extends AbstarctObserver {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        String  event = subject.getEvent();
        System.out.println("BinaryObserver=" + event);

    }
}
