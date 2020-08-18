package rubbish.visitor;

/**
 * @ClassName NonQualifiedMechanic
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-19 11:04
 **/
public class NonQualifiedMechanic implements Mechanic {
    @Override
    public void visit(CarCompant carCompant) {
        carCompant.setBroken(false);
    }

    @Override
    public String getName() {
        return "qualified";
    }
}
