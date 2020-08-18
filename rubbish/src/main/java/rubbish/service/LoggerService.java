package rubbish.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName LoggerService
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-08-16 16:22
 **/
@Service
public class LoggerService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void test(String sid){
        logger.info("LoggerService test sid={}",sid);
    }
}
