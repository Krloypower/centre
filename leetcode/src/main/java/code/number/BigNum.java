package code.number;

/**
 * @ClassName BigNum
 * @Description TODO
 * @Author kang.ouyang
 * @Date 2020-06-19 11:06
 **/
public class BigNum {

    public static String soulation(String num1, String num2) {

        if (num1.length() == 0 || num2.length() == 0){
            return "0";
        }

        int[] result = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int low = i + j + 1;
                int hight = i + j;
                mul += result[low];
                result[low] = mul % 10;
                result[hight] += mul / 10;
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int res : result){
            if (!(sb.length() == 0 && res==0)){
                sb.append(res);
            }
        }
        return sb.length()==0? "0":sb.toString();
    }

    public static void main(String[] args) {
        String n1 = "456";
        String n2 = "123";
        System.out.println(soulation(n1, n2));
    }

}
