package com.centre.datebase.mapper;

import com.centre.datebase.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class TestMapperTest extends BaseTest {

    @Autowired
    private TestMapper testMapper;

    @Test
    void select1() {
        System.out.println(testMapper.select1());
    }

    @Test
    void select2() {
    }
}