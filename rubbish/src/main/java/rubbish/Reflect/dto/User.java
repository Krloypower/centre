package rubbish.Reflect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-05-28 18:39
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;

    private Integer age;
}
