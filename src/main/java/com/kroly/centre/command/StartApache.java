package com.kroly.centre.command;

/**
 * @ClassName StartApache
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-18 15:25
 **/
public class StartApache extends ServerCommand {

    public StartApache(Server server) {
        super(server);
    }

    @Override
    public void execute() {
        server.launchCommand("sudo service apache2 start");
    }
}
