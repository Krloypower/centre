package com.kroly.centre;

import com.kroly.centre.util.Search;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName RegexTest
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-08-09 10:32
 **/
public class RegexTest extends BaseTest {

    @Autowired
    Search search;

    @Test
    public void test() throws Exception{
        search.execut();
    }
}
