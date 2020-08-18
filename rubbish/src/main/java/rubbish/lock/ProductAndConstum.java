package rubbish.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ProductAndConstum
 * @Description TODO
 * @Author kang.ouyang
 * @Date 2020-06-09 10:10
 **/
public class ProductAndConstum {

    public static List<String> list = new ArrayList<>(5);

    private final int MAX = 5;

    public synchronized void pro(String key) throws InterruptedException {

        while (MAX == list.size()) {
            wait();
        }
        list.add(key);
        notifyAll();
    }

    public synchronized void release() throws InterruptedException {
        while (list.size() == 0) {
            wait();
        }
        list.remove(0);
        notifyAll();
    }

    public static void main(String[] args) {
        ProductAndConstum productAndConstum = new ProductAndConstum();

        ScheduledExecutorService printer = Executors.newScheduledThreadPool(1);
        printer.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(ProductAndConstum.list.size());
            }
        }, 0, 1, TimeUnit.SECONDS);


        ExecutorService service = Executors.newFixedThreadPool(11);

        for (int i = 0; i < 10; i++) {

            new Thread(() -> {
                while (true) {
                    try {
                        productAndConstum.pro("a");
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;

                    }
                }
            }).start();

//           rubbish.service.execute(() -> {
//
//           });
        }

        for (int i = 0; i < 1; i++) {

            new Thread(() -> {
                while (true) {
                    try {
                        productAndConstum.release();
                        Thread.sleep(10);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }).start();
//            rubbish.service.execute(() -> {
//
//            });
        }
//        rubbish.service.shutdown();
    }
}
