package rubbish.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Subject
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/9/18
 * @Version 1.0
 **/
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private String event;

    public void attch(Observer observer){
        observers.add(observer);
    }

    public String getEvent(){
        return this.event;
    }

    public void update(String  event){
        this.event = event;
        notifyIt();
    }

    public void notifyIt(){
        for (Observer observer :observers){
            observer.update();
        }
    }

}
