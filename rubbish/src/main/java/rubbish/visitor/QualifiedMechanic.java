package rubbish.visitor;

/**
 * @ClassName QualifiedMechanic
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-19 11:03
 **/
public class QualifiedMechanic implements Mechanic {
    @Override
    public void visit(CarCompant carCompant) {
        carCompant.setBroken(true);
    }

    @Override
    public String getName() {
        return "qualified";
    }
}
