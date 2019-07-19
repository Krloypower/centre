package com.kroly.centre.command;

/**
 * @ClassName Administrator
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-18 15:27
 **/
public class Administrator {
    private ServerCommand serverCommand;

    public void setServerCommand(ServerCommand serverCommand){
        this.serverCommand = serverCommand;
    }

    public void typeEnter(){
        serverCommand.execute();
    }
}
