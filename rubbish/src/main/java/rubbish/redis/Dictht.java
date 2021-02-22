package rubbish.redis;

import lombok.Data;

/**
 * @ClassName Dictht
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/2/22
 * @Version 1.0
 **/
@Data
public class Dictht {

    private long size;

    private long sizeMaSK;

    private DictEntry[] dictEntries;

}
