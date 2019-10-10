package com.kroly.centre.ChainOfResponsibility;


/**
 * @InterfaceName StudyPrepareFilter
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-10-10 10:57
 **/
public interface StudyPrepareFilter {
    void doFilter(PreparationList preparationList, FilterChain filterChain);
}
