package com.kroly.centre.ChainOfResponsibility;

/**
 * @ClassName WashFace
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-10-10 11:04
 **/
public class WashFace implements StudyPrepareFilter {
    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        if (preparationList.isWashFace()){
            System.out.println("洗脸");
        }
        filterChain.doFilter(preparationList , filterChain);
    }
}
