package Demo;

import java.util.Arrays;

public class CloneDemo {
    public static void main(String[] args){
        cloneTest1();
        cloneTest2();
    }
    private static void cloneTest1(){
        int [] arr1=new int[]{1,0,0,8,6};
        int [] arr2=new int[arr1.length];

        arr2=arr1.clone();

        System.out.println("arr1= " + Arrays.toString(arr1));
        System.out.println("arr2= " + Arrays.toString(arr2));
        System.out.println("============================");

//        改变拷贝后的数组，原数组并未跟着改变，表明对于基本数据类型，clone是深拷贝
        arr2[0]=100;
        System.out.println("arr1= " + Arrays.toString(arr1));
        System.out.println("arr2= " + Arrays.toString(arr2));
    }

    private static void cloneTest2(){
        User user1=new User("aaa","18");
        User user2=new User("bbb","19");
        User[] userArr1=new User[2];
        userArr1[0]=user1;
        userArr1[1]=user2;

        User[] userArr2=userArr1.clone();

        System.out.println("===============================");
        System.out.println("userArr1 = "+Arrays.toString(userArr1));
        System.out.println("userArr2 = "+Arrays.toString(userArr2));
        System.out.println("===============================");

//        改变拷贝后的user数组，原user数组也跟着改变了，表明对于对象而言，clone也是浅拷贝
        userArr2[0].setUsername("ccc");
        userArr2[0].setPassword("20");
        System.out.println("UserArr1 = " +Arrays.toString(userArr1));
        System.out.println("userArr2 = " +Arrays.toString(userArr2));
    }
}
