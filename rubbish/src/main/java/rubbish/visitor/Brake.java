package rubbish.visitor;

/**
 * @ClassName Brake
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-19 11:06
 **/
public class Brake extends CarCompant {
    @Override
    public void acpect(Mechanic mechanic) {
        mechanic.visit(this);
    }
}
