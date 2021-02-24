package com.centre.datebase.service;

import com.centre.datebase.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName TransactionalService
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/2/24
 * @Version 1.0
 **/
@Service
public class TransactionalService {

    @Autowired
    private TestMapper testMapper;


    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Long test1() throws Exception{
        Long aLong = testMapper.select1();
        Thread.sleep(1000 * 10);
        Long aLong1 = testMapper.select2();
        return aLong1 + aLong;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Long test2() throws Exception{
        Long aLong1 = testMapper.select2();
        Thread.sleep(1000 * 10);
        Long aLong = testMapper.select1();
        return aLong1 + aLong;
    }

}
