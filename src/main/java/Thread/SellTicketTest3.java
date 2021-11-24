package Thread;

public class SellTicketTest3 {
    public static void main(String[] args) {
        TicketWindwo3 tw = new TicketWindwo3();
        for (int i = 1; i < 4; i++) {
            Thread t = new Thread(tw, "窗口" + i);
            t.start();
        }
    }
}
class TicketWindwo3 extends Thread{
    private int ticket=50;
    public void run (){
        while(true){
            if(ticket>0){
                try{
                    Thread.sleep(100);
                }
                catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
                System.out.println(Thread.currentThread().getName()+"卖出了一张票，当前票数为："+ --ticket);
            }
            else {
                System.out.println(Thread.currentThread().getName()+"余票不足，无法售票！");
                break;
            }
        }
    }
}

