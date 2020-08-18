package rubbish.command;

/**
 * @ClassName StartTomcat
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-18 15:24
 **/
public class StartTomcat extends ServerCommand {

    public StartTomcat(Server server) {
        super(server);
    }

    @Override
    public void execute() {
        server.launchCommand("sudo rubbish.service tomcat7 start");
    }
}
