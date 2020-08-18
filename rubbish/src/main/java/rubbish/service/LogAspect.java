package rubbish.service;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName LogAspect
 * @Description TODO
 * @Author kang.ouyang
 * @Date 2020-04-24 10:34
 **/
@Component
@Aspect
@Slf4j
public class LogAspect {

    @Pointcut("@annotation(rubbish.service.Log)")
    public void logPointCut(){}

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        log.info("beginTime={}",beginTime);
        Object result = point.proceed();
        log.info("time={},endTime={}",System.currentTimeMillis()- beginTime,System.currentTimeMillis());
        return result;
    }
}
