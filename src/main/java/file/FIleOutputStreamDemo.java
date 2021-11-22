package file;

import java.io.FileOutputStream;
import java.io.IOException;

public class FIleOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        // 使⽤⽂件名称创建流对象
        FileOutputStream fos = new FileOutputStream("fos.txt");
        // 写出数据
        // 写出第1个字节
        fos.write(97);
        // 写出第2个字节
        fos.write(98);
        // 写出第3个字节
        fos.write(99);
        // 关闭资源
        fos.close();
    }
}
