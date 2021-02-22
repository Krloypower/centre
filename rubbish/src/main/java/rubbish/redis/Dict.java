package rubbish.redis;

import lombok.Data;

/**
 * @ClassName Dict
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/2/22
 * @Version 1.0
 **/
@Data
public class Dict {
    private Dictht[] dicthts = new Dictht[2];

    private int reHashIdx;

    private Object dateType;

    private Object privateType;

}
