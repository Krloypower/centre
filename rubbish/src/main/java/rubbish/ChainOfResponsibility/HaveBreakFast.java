package rubbish.ChainOfResponsibility;

/**
 * @ClassName HaveBreakFast
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-10-10 11:07
 **/
public class HaveBreakFast implements StudyPrepareFilter {
    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        if (preparationList.isHaveBreakFast()){
            System.out.println("吃早餐");
        }
        filterChain.doFilter(preparationList,filterChain);
    }
}
