package String;

public class StringTest {
    public static void main(String[] args){
//          test1();
//          test2();
//            test3();
        test4();
    }

    private static void test1() {
        int a = 0;
        String b = String.valueOf(a);
        System.out.println(b);
    }
    private static void test2(){
        Object a=0;
        if(a instanceof String){
            String b=(String) a;
            System.out.println(b);
        }
        else {
            System.out.println("error");
        }
    }

    private static void test3(){
        Integer a=0;
        String b=a.toString();
        System.out.println(b);
    }

    private static void test4(){
        Integer a1=null;
        String b1=String.valueOf(a1);
        System.out.println(b1);
        System.out.println(b1==null);
        System.out.println(b1.equals("null"));
        System.out.println("=================================");
        Object a2=null;
        String b2=(String) a2;
        System.out.println(b2);
        System.out.println(b2==null);
        System.out.println(b2.equals("null"));

    }


}

