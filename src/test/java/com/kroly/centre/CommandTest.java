package com.kroly.centre;

import com.kroly.centre.annotation.service.Log;
import com.kroly.centre.command.Administrator;
import com.kroly.centre.command.Server;
import com.kroly.centre.command.StartApache;
import com.kroly.centre.command.StartTomcat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName CommandTest
 * @Description 命令模式的测试方法
 * @Author ouyangkang
 * @Date 2019-07-18 15:30
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class CommandTest {

    @Test
    public void test(){
        Administrator admin = new Administrator();
        Server server = new Server();
        // 添加命令
        admin.setServerCommand(new StartApache(server));
        admin.typeEnter();

        admin.setServerCommand(new StartTomcat(server));
        admin.typeEnter();

        System.out.println(server.getExecutedCommands());
    }
}
