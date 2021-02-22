package rubbish.redis;

import lombok.Data;

/**
 * @ClassName DictEntry
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/2/22
 * @Version 1.0
 **/
@Data
public class DictEntry<K, V> {

    private K key;

    private V value;

    private DictEntry<K, V> next;

}
