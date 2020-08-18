package rubbish.strategy;

public enum StrategyEnum {
    BACKDOOR("BackDoor","乔国老开后门"),
    GREENLIGHT("GreenLight","吴国太开绿灯"),
    PostBreak("PostBreak","孙夫人断后");


    private String type;
    private String name;



    StrategyEnum(String type,String name){
        this.type = type;
    }
    public String getType() {
        return type;
    }


}
