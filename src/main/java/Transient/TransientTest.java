package Transient;

import Copy.User;

import java.io.*;


public class TransientTest {
    public static void main(String[] args){
        try{
            serializeUser();
            deSerializeUser();
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    private static void deSerializeUser() throws IOException,ClassNotFoundException {
        File file=new File("data.txt");
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
        User user=(User) ois.readObject();
        
        System.out.println("普通字段序列化：username= "+ user.getUsername());
        System.out.println("添加了transient关键字序列化: password= " +user.getPassword());
    }

    private static void serializeUser() throws IOException{
        User user=new User();
        user.setUsername("松山院");
        user.setPassword("123456");

        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("data.txt"));
        oos.writeObject(user);
        oos.close();

        System.out.println("普通字段序列化：username= "+ user.getUsername());
        System.out.println("添加了transient关键字序列化: password= " +user.getPassword());
    }
}
