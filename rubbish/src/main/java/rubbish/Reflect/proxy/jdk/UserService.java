package rubbish.Reflect.proxy.jdk;


import rubbish.Reflect.dto.User;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-05-29 11:06
 **/
public interface UserService {

    void setUser(String name,Integer age);

    User getUser();
}
