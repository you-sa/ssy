import java.io.File;

public class FilePath {
    public  static  void main (String[] args){
        File f=new File("D:/aaa/hello.txt");
        System.out.println(f.getAbsolutePath());

        File f2=new File("D:/java/project/src/BTree.java");
        System.out.println(f2.getAbsolutePath());
    }
}
