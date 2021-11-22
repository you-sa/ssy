package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamConstructor {
    public static void main(String[] args) throws IOException {
        // 使⽤File对象创建流对象
        File file = new File("a.txt");
        FileOutputStream fos = new FileOutputStream(file);

        // 使⽤⽂件名称创建流对象
        //FileOutputStream fos = new FileOutputStream("b.txt");
    }
}
