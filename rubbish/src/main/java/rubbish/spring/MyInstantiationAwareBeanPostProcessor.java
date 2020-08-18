package rubbish.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

/**
 * @ClassName MyInstantiationAwareBeanPostProcessor
 * @Description TODO
 * @Author kang.ouyang
 * @Date 2020-05-22 10:53
 **/
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    public MyInstantiationAwareBeanPostProcessor() {
        super();
        System.out.println("这是InstantiationPostProcessor实现类构造器");
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("InstantiationPostProcessor调用Before方法");
        return super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("InstantiationPostProcessor调用 After方法");
        return super.postProcessAfterInstantiation(bean, beanName);
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {

        System.out.println("InstantiationAwareBeanPostProcessor调用postProcessPropertyValues方法");
        return super.postProcessProperties(pvs, bean, beanName);
    }
}
