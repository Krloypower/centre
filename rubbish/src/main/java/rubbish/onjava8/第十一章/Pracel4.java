package rubbish.onjava8.第十一章;

/**
 * @ClassName Pracel4
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/19
 * @Version 1.0
 **/
public class Pracel4 {

    private String  label;

    private class PContents implements Content {

        private int i = 10;

        @Override
        public int value() {
            return i;
        }
    }

    private class PDestination implements Destiation {

        private String label;

        public PDestination(String label){
            this.label = label;
        }

        @Override
        public String readLabel() {
            return this.label;
        }
    }

    class Temp{
        private String a ="10";

        public String get(){
            return a;
        }
    }

    public Content getContent(){
        return new PContents();
    }

    public Destiation getDestination(String label){
        return new PDestination(label);
    }

    public Temp getTemp(){
        return new Temp();
    }

}
