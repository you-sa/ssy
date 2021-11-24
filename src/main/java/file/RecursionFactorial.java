package file;

public class RecursionFactorial {
    public static void main(String[] args) {
        int res = getFactorial(5);
        System.out.println(res);
    }
    public static int getFactorial(int num) {
        //1的阶乘为1
        if (num == 1) {
            return 1;
        }
        //n不为1时,⽅法返回 n! = n*(n-1)! 递归调⽤getValue⽅法
        return num * getFactorial(num - 1);
    }
}
