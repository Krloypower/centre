package code.first;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName 第三题
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/4
 * @Version 1.0
 **/
public class 第三题 {

    public static int lengthOfLongestSubstring(String s) {
        int ans = 0, start =0,end=0;
        Map<Character, Integer> map = new HashMap<>();

        for (;end <s.length(); end ++){
            Character charAt = s.charAt(end);

            if (map.containsKey(charAt)){
                start = Math.max(map.get(charAt), start);
            }
            ans = Math.max(end - start + 1, ans);
            map.put(charAt, end + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
    }
}
