package com.kroly.centre;

import com.alibaba.fastjson.JSONObject;
import com.kroly.centre.util.ReadTxt;
import com.kroly.centre.util.ReadXlsx;
import com.kroly.centre.visitor.*;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @ClassName VisitorTest
 * @Description 访问者模式
 * @Author ouyangkang
 * @Date 2019-07-19 11:14
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class VisitorTest {

    @Resource
    ReadXlsx readXlsx;

    @Resource
    ReadTxt readTxt;

    @Test
    public void test(){
        CarCompant car = new Car();
        Mechanic mechanic = new NonQualifiedMechanic();
        car.acpect(mechanic);
        System.out.println(car.getBroken());
    }

    @Test
    public void readXlsxTest(){

        try {
            readXlsx.execute();
//            readXlsx.sendGet("song","let go");
//            readXlsx.sendGet("","");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readTxtTest(){
        try {
            readTxt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
