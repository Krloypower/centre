package rubbish.command;

/**
 * @ClassName ServerCommand
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-18 15:18
 **/
public abstract class ServerCommand {
    protected Server server;

    public ServerCommand(Server server){
        this.server = server;
    }

    public abstract void execute();
}
