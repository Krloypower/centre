package rubbish.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Server
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-18 15:19
 **/
public class Server {
    private List<String> executedCommands = new ArrayList<>();

    public void launchCommand(String command){
        System.out.println("Executing: " + command + " on server");
        this.executedCommands.add(command);
    }

    public List<String> getExecutedCommands(){
        return executedCommands;
    }
}
