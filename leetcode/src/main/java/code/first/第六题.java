package code.first;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName 第六题
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/5
 * @Version 1.0
 **/
public class 第六题 {

    public static String convert(String s, int numRows){

        if (numRows == 1){
            return s;
        }
        int length = s.length();

        List<StringBuffer> rows = new ArrayList<>();

        for (int i = 0; i<length; i++){
            rows.add(new StringBuffer());
        }

        int row = 0;
        boolean goDown = false;

        for(char temp : s.toCharArray()){
            rows.get(row).append(temp);
            if (row == 0 || row == numRows - 1){
                goDown = !goDown;
            }
            row += goDown ? 1 : -1;
        }

        StringBuffer ret = new StringBuffer();
        for (StringBuffer stringBuffer : rows){
            ret.append(stringBuffer);
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING",3));
    }
}
