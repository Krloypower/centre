package rubbish.visitor;

/**
 * @ClassName Engine
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-19 11:05
 **/
public class Engine extends CarCompant {
    @Override
    public void acpect(Mechanic mechanic) {
        mechanic.visit(this);
    }
}
