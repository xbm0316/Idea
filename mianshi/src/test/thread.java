package test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class thread {



    public static void main(String[] args) {
        ticket a = new ticket();
//        new Thread(()->{ for(int i = 0;i<20;i++) a.sale(); },"a").start();
//        new Thread(()->{ for(int i = 0;i<20;i++) a.sale(); },"b").start();
//        new Thread(()->{ for(int i = 0;i<20;i++) a.sale(); },"c").start();


    }

}


class ticket{
    //票的数量
    private int t = 10;


    public synchronized void sale(){
        if(t>0){
            for(int i = 1;i<11;i++){

                System.out.println("卖出了："+t+"张票");
                t--;
            }
        }
    }



}