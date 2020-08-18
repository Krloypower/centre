package rubbish.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @ClassName CacheAspect
 * @Description TODO
 * @Author kang.ouyang
 * @Date 2020-05-29 11:37
 **/
@Aspect
@Component
public class CacheAspect {

    @Pointcut("@annotation(rubbish.service.Cache)")
    public void addCache(){}

    @Around("addCache()")
    public Object around(ProceedingJoinPoint point){
        MethodSignature signature = (MethodSignature) point.getSignature();
        Cache annotation = signature.getMethod().getAnnotation(Cache.class);
        if (annotation != null){
           return annotation.value();
        }else {
            try {
                return point.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }
}
