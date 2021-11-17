import java.io.File;

public class FileConstructor {
    public static void main (String[] args){
//        文件路径名
        String pathname="/D/aaa/hello.txt";
        File file1=new File(pathname);
        System.out.println(file1);
//        通过父路径和子路径字符串
        String parent ="/D/aaa";
        String child1="hello.txt";
        File file2 = new File(parent, child1);
        System.out.println(file2);

        // 通过⽗级File对象和⼦路径字符串
        File parentDir = new File("/D/aaa");
        String child2 = "hello.txt";
        File file3 = new File(parentDir, child2);
        System.out.println(file3);
    }
}
