package file;

import java.io.File;

public class FileJudgeMethods {
    public static void main(String[] args){
        File f = new File("D:/java/project/src/BTree/BTNode.java");
        File f2 = new File("D:/aaa");
        // 判断是否存在
        System.out.println("D:/java/project/src/BTree.java 是否存在:" + f.exists());
        System.out.println("D:/aaa 是否存在" + f2.exists());
        // 判断是⽂件还是⽬录
        System.out.println("D:/aaa 是⽂件?:" +
                f2.isFile());
        System.out.println("D:/aaa 是⽬录?:" +
                f2.isDirectory());
    }
}
