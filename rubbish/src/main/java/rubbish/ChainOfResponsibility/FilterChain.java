package rubbish.ChainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FilterChain
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-10-10 10:58
 **/
public class FilterChain implements StudyPrepareFilter {

    private int pos=0;

    private List<StudyPrepareFilter> studyPrepareFilters;

    private Study study;

    public FilterChain(Study study){
        this.study = study;
    }

    public void addFilter(StudyPrepareFilter studyPrepareFilter){
        if (studyPrepareFilters == null){
            studyPrepareFilters = new ArrayList<>();
        }
        studyPrepareFilters.add(studyPrepareFilter);

    }

    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        if (pos == studyPrepareFilters.size()){
            study.toStudy();
        }else {
            studyPrepareFilters.get(pos++).doFilter(preparationList,filterChain);
        }

    }
}
