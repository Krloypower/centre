package com.kroly.centre.jdbc;

import com.kroly.centre.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @ClassName JDBCTest
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/8/3
 * @Version 1.0
 **/
public class JDBCTest extends BaseTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test(){
        String sql = "insert into test values('😁')";
//        String sql = "insert into test values('111')";
        int update = 0;

        try {
            update = jdbcTemplate.update(sql);
            System.out.println(update);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
