package IO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderTest {
    private static final String CHINESE_FILE_PATH = "fw.txt";

    public static void main(String[] args) {
        readerTest(new File(CHINESE_FILE_PATH));
    }

    /**
     * 字符流读取中文文档，解决字节流读取中文乱码问题
     *
     * @param file 中文文件
     */
    private static void readerTest(File file) {
        Reader fr = null;
        try {
            fr = new FileReader(file);
            int read;
            while ((read = fr.read()) != -1) {
                System.out.print((char) read);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}
