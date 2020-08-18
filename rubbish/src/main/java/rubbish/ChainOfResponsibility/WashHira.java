package rubbish.ChainOfResponsibility;

/**
 * @ClassName WashHira
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-10-10 11:06
 **/
public class WashHira implements StudyPrepareFilter {
    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        if (preparationList.isWashHair()){
            System.out.println("洗头");
        }
        filterChain.doFilter(preparationList,filterChain);
    }
}
