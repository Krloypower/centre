package rubbish.ChainOfResponsibility;

/**
 * @ClassName main
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-10-10 11:08
 **/
public class main {
    public static void main(String[] args) {
        FilterChain chain = new FilterChain(new Study());
        chain.addFilter(new WashHira());
        chain.addFilter(new WashFace());
        chain.addFilter(new HaveBreakFast());
        PreparationList preparationList = new PreparationList();
        preparationList.setWashHair(true);
        preparationList.setWashFace(true);
        preparationList.setHaveBreakFast(false);

        chain.doFilter(preparationList,chain);
    }
}
