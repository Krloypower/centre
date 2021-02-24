package com.centre.datebase.service;

import com.centre.datebase.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

class TransactionalServiceTest extends BaseTest {

    @Autowired
    private TransactionalService service;

    @Test
    void test1() throws Exception {
        service.test1();
    }

    @Test
    void test2() throws Exception {
        service.test2();
    }
}