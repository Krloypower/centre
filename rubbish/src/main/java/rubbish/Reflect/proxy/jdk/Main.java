package rubbish.Reflect.proxy.jdk;


import rubbish.Reflect.dto.User;
import rubbish.Reflect.proxy.jdk.impl.UserServiceImpl;
import rubbish.Reflect.proxy.jdk.porxy.CglbProxy;
import rubbish.Reflect.proxy.jdk.porxy.JdkProxy;

/**
 * @ClassName Main
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-05-29 11:18
 **/
public class Main {

    public static void main(String[] args) {
        UserService proxy = (UserService) new JdkProxy().newProxy(new UserServiceImpl());
        proxy.setUser("ouyangk",22);

        UserService proxy1 = (UserService) new CglbProxy().createProxy(new UserServiceImpl());

        User user = proxy1.getUser();
        System.out.println(user);
    }
}
