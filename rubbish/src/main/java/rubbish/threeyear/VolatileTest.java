package rubbish.threeyear;

/**
 * @ClassName VolatileTest
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020-01-08 10:58
 **/
public class VolatileTest {
    private static int num = 1;
    private volatile  static int vNum = 1;

    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();
        test.runNum();
        test.runVNum();
    }

    public void runNum() {
        Thread threadA = new Thread(() -> {
            num++;
        });
        Thread threadB = new Thread(() -> {
            vNum++;
        });
        threadA.start();
        threadB.start();
    }

    public void runVNum() {
        Thread threadA = new Thread(() -> {
            if (num == 2) {
                System.out.println("runNum num="+vNum);
            }
        });

        Thread threadB = new Thread(() -> {
            if (vNum == 2) {
                System.out.println("runVNum num="+vNum);
            }
        });
        threadA.start();
        threadB.start();

    }

}
