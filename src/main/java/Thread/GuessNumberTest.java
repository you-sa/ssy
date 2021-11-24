package Thread;

public class GuessNumberTest {
    public static void main(String[] args){
        System.out.println("1号竞猜机器启动");
        Thread thread1=new GuessNumber(7);
        thread1.setName("1号机器竞猜");
        thread1.start();

        System.out.println("2号竞猜机器启动");
        Thread thread2=new GuessNumber(7);
        thread2.setName("2号机器竞猜");
        thread2.start();

        try {
            thread2.join();
        }
        catch (InterruptedException e){
            System.err.println(e.getMessage());
        }
        System.out.println("主线程结束");
    }
}
