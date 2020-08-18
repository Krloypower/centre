package rubbish.Data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Person
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-06-17 11:44
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private Integer id;
    private String name;
    private Integer sex;
    private Integer age;
}
