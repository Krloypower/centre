package nio.code;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

/**
 * @ClassName nio
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/9/17
 * @Version 1.0
 **/
public class FileNio {

    private static final String path = "/Users/ouyangkang/temp/nio_test.txt";


    public static void main(String[] args) throws Exception {
        nioTest();
//        method2();
    }
    public static void nioTest() throws Exception{
        RandomAccessFile file = new RandomAccessFile(path, "rw");
        FileChannel channel = file.getChannel();

        Selector selector = Selector.open();

        ByteBuffer bf = ByteBuffer.allocate(1024);
        int read = channel.read(bf);
        while (read != -1){
            bf.flip();
            while (bf.hasRemaining()){
                System.out.print((char) bf.get());
            }
            bf.compact();
            channel.read(bf);
        }
    }

    public static void method2() {
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(path));
            byte[] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while (bytesRead != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    System.out.print((char) buf[i]);
                }
                bytesRead = in.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
