package rpc.io;

import java.io.*;

/**
 * @ClassName IoExample
 * @Description io 例子
 * <p>
 * <p>
 * 1. InputStream , OutputStream 基于字节操作的 IO
 * 2. Writer, Reader 基于字符操作的 IO
 * 3. File 基于文件操作的 IO
 * 4. Socker 基于网络操作的 IO
 * @Author ouyangkang
 * @Date 2020/8/18
 * @Version 1.0
 **/
public class IoExample {

    private static String path = "/Users/ouyangkang/Documents/result.txt";
    private static String outPath = "/Users/ouyangkang/Documents/result1.txt";

    public static void main(String[] args) throws Exception {
//        InputStreamExample();
//        OutputStreamExample();
//        WriterExample();
        ReadExample();
    }

    public static void InputStreamExample() throws Exception {
        InputStream inputStream = new FileInputStream(path);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        String result = new String(bytes, "utf-8");
        System.out.println(result);
        inputStream.close();
    }

    public static void OutputStreamExample() throws Exception {
        OutputStream outputStream = new FileOutputStream(outPath);
        String out = new String("Hello , 你好!!!");
        outputStream.write(out.getBytes("utf-8"));
        outputStream.close();
    }

    public static void WriterExample() throws Exception {
        Writer writer = new FileWriter(outPath);
        writer.append("啊啊啊，llll");
        writer.flush();
        writer.close();
    }

    private static void ReadExample() throws Exception {
        Reader reader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String readLine = null;
        while ((readLine= bufferedReader.readLine()) != null){
            System.out.println(readLine);
        }

        bufferedReader.close();
        reader.close();



    }

}
