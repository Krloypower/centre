package rubbish.Observer;

import lombok.Data;

import java.util.EventObject;

/**
 * @ClassName MessageEvent
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/9/21
 * @Version 1.0
 **/
public class MessageEvent extends EventObject {

    private Message message;

    /**
     * Constructs a prototypical Event.
     *
     * @param message The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MessageEvent(Message message) {
        super(message);
        this.message = message;
    }


    public Message getMessage(){
        return this.message;
    }
}
