package Thread;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeThread implements Runnable{
    private final JLabel timeLabel;

    public TimeThread(JLabel timeLabel){
        this.timeLabel=timeLabel;
    }

    public void run(){
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while(true){
            timeLabel.setText(df.format(new Date()));
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
