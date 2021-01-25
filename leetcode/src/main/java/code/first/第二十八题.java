package code.first;

/**
 * @ClassName 第二十八题
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/12
 * @Version 1.0
 **/
public class 第二十八题 {

    public static int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int hay = haystack.length();
        int need = needle.length();
        if (need > hay) {
            return -1;
        }

        haystack.indexOf("abc");


        for (int i = 0; i < hay; i++) {
            for (int j = 0, k = i; j < need && k < hay; j++) {
                if (haystack.charAt(k) == needle.charAt(j)) {
                    if (j == need - 1) {
                        return i;
                    }
                    k++;
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi","issipi"));
    }
}
