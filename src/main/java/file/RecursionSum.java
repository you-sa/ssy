package file;

public class RecursionSum {
    public static void main(String[] args) {
        //计算1~num的和，使⽤递归完成
        int num = 5;
        // 调⽤求和的⽅法
        int sum = getSum(num);
        // 输出结果
        System.out.println(sum);
    }
    public static int getSum(int num) {
        //num为1时,⽅法返回1,相当于是⽅法的出⼝,num总有是1的情况
        if (num == 1) {
            return 1;
        }
        //num不为1时,⽅法返回 num +(num-1)的累和, 递归调⽤getSum⽅法
        return num + getSum(num - 1);
    }
}
