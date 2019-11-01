package com.kroly.centre.regex;

import sun.tools.jconsole.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Bracket
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-10-31 11:02
 **/
public class Bracket {

    public static String cleanBracketFromTrackTitle(String trackTitle){


//        String regex = "微信.*[A-Za-z0-9]+.*$";
//
//        String regex = "[第其]*[零一二三四五六七八九十百千\\d]*[集回章期篇话页节部卷]*";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(trackTitle);
//        if (matcher.find()){
//            String group = matcher.group();
//            trackTitle  = trackTitle.replace(group,"");
//            return trackTitle;
//        }



        String  cleanRegex = "[\\(\\（\\[\\【].*[\\)\\）\\]\\】]";
        Pattern cleanPattern = Pattern.compile(cleanRegex);
        Matcher cleanMatcher = cleanPattern.matcher(trackTitle);
        if (cleanMatcher.find()){
            String clean = cleanMatcher.group();
            return trackTitle.replace(clean, "");
        }

        return trackTitle;
    }

    public static void main(String[] args) {
        System.out.println(cleanBracketFromTrackTitle("（经典长篇《百年孤独》已更完，畅听无限，欢迎收听）"));
    }
}
