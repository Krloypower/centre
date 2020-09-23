package rubbish.Observer;

/**
 * @ClassName CharObserver
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/9/18
 * @Version 1.0
 **/
public class CharObserver extends AbstarctObserver{

    public CharObserver(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        System.out.println("CharObserver="+subject.getEvent());
    }
}
