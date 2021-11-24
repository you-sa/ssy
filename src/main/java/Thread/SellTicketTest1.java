package Thread;

public class SellTicketTest1 {
    public static void main(String[] args){
        TicketWindwo tw1=new TicketWindwo();
        TicketWindwo tw2=new TicketWindwo();
        TicketWindwo tw3=new TicketWindwo();

        tw1.setName("窗口1");
        tw2.setName("窗口2");
        tw3.setName("窗口3");

        tw1.start();
        tw2.start();
        tw3.start();
    }
}
    class TicketWindwo extends Thread{
        private int ticket=50;
        public void run (){
            while(true){
                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"卖出了一张票，当前票数为："+ --ticket);
                }
                else {
                    System.out.println(Thread.currentThread().getName()+"余票不足，无法售票！");
                    break;
                }
            }
        }
    }

