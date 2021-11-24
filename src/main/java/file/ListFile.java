package file;

import java.io.File;
import java.util.Objects;

public class ListFile {
    public static void main(String[] args) {
        File dir = new File("D:/aaa");
        //获取当前⽬录下的⽂件以及⽂件夹对象，通过⽂件对象可以获取更多信息
        File[] files = dir.listFiles();
        for (File file : Objects.requireNonNull(files)) {
            System.out.println(file);
        }
    }
}
