import java.io.*;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IoDemo {
    public static void main(String[] args) throws IOException{
        printWriterDemo();
    }

    public static void characterDemo() throws UnsupportedEncodingException{
        byte[] bytes ="你".getBytes();
        System.out.println(Arrays.toString(bytes));

        bytes="你".getBytes("GBK");
        System.out.println(Arrays.toString(bytes));

        bytes="你".getBytes(StandardCharsets.UTF_16LE);
        System.out.println(Arrays.toString(bytes));

        bytes="你".getBytes(StandardCharsets.UTF_16LE);
        System.out.println(Arrays.toString(bytes));
    }

    public static  void transferDemo() throws IOException{

        String fileName="D:/aaa/hello.txt";

        OutputStreamWriter osw =new OutputStreamWriter(new FileOutputStream(fileName));

        osw.write("您好");
        osw.flush();
        osw.close();

        String fileName2="D:/aaa/hello2.txt";

        OutputStreamWriter osw2=new OutputStreamWriter(new FileOutputStream(fileName2));
        osw2.write("您好");
        osw2.flush();
        osw2.close();

    }

    public static void transferReader() throws IOException{
        String fileName ="D:/aaa/hello.txt";

        InputStreamReader isr=new InputStreamReader(new FileInputStream(fileName));

        InputStreamReader isr2=new InputStreamReader(new FileInputStream(fileName),"GBK");

        int read;
        System.out.println("\n************使用默认编码读取************\n");

        while((read=isr.read())!=-1){
            System.out.print((char) read);
        }
        isr.close();
        System.out.println("\n************使用GBK编码读取************\n");

        while ((read=isr2.read())!=-1){
            System.out.print((char) read);
        }
        isr2.close();
    }

    public static void fileWriterDemo() throws IOException{

        FileWriter fw=new FileWriter("fw.txt");

        fw.write(97);
        fw.flush();

        char[] chs="ABCDED".toCharArray();
        fw.write(chs);
        fw.flush();

        fw.write(chs,1,3);
        fw.flush();

        fw.write("Java工程师");
        fw.flush();
        fw.close();
    }

    public static void fileReaderDemo() throws IOException{

        FileReader fr=new FileReader("read.txt");

        int len;

        char[] buf=new char[2];

        while((len=fr.read(buf))!=-1){
            System.out.println(new String(buf,0,len));
        }
        fr.close();
    }

    public static void bufferedWriterDemo() throws IOException{

        BufferedWriter bw=new BufferedWriter(new FileWriter("out.txt"));

        bw.write("Java");

        bw.newLine();
        bw.write("程序");
        bw.newLine();
        bw.write("员");
        bw.newLine();

        bw.close();
    }

    public static void bufferedReaderDemo() throws  IOException{
        BufferedReader br=new BufferedReader(new FileReader("read.txt"));

        String line =null;

        while((line=br.readLine())!=null){
            System.out.print(line);
            System.out.println("------");
        }

        br.close();
    }

    public static void txtSort() throws IOException{

        ArrayList<String> list=new ArrayList<>();

        BufferedReader br=new BufferedReader(new FileReader("out.txt"));

        BufferedWriter bw=new BufferedWriter(new FileWriter("out.txt"));

        String line =null;
        while((line=br.readLine())!=null){
            list.add(line);
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.charAt(0) - o2.charAt(0);
            }
        });

        for(String s:list) {
            bw.write(s);
            bw.newLine();

        }
        bw.close();
    }

    public static void printWriterDemo() throws IOException{
        PrintWriter pw=new PrintWriter(new FileWriter("a.txt"));
        pw.println(97);
        pw.println(98);
        pw.close();
    }


}
