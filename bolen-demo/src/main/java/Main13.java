
import java.util.*;
 
class Msg{//编写一个包含共享数据的类，各个线程操作其中的数据
    public char[] strbf;//写入这个字符数组
    public int index=1;//控制由哪个线程进行操控该数据类对象
    public int num;//用户输入的组数
    public int count=0;//数组下标计数
 
    public Msg(int num){//初始化
        this.num = num;
        this.index = 1;
        this.count = 0;
        this.strbf = new char[4*num];
    }
     
    public  synchronized void appendA(){//当某个对象的一个方法被同步后，该对象的其他方法不能被别的线程访问
        while(this.count<this.num*4) {//一定是当前计数还没计满时操作
            while(this.index!=1){//非对应线程等待，一定要用while，防止线程A再次获得对象锁
                if(this.count>=this.num*4) { //加条件退出，让线程满足条件时跳出销毁  
                    break;
                }
                try{
                   this.wait(); //释放对象锁
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            if(this.count>=this.num*4) {   //加条件退出，让线程满足条件时跳出销毁  
                System.out.println("A"+this.count);//在线编程说有数组越界问题，我表示抗议，这里的输出结果说明没有数组越界问题
                break;
            }
            this.strbf[count] = 'A';//对应线程进行操作
            this.count++;//计数加一
            this.index = 2;//指定下一个线程的标记
            this.notifyAll();//唤醒别的线程，不立即释放对象锁
        }
        System.out.println(this.strbf);
    }
    public  synchronized void appendB(){
        while(this.count<this.num*4) {
            while(this.index!=2){
                if(this.count>=this.num*4) {   
                    break;
                }
                try{
                   this.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            if(this.count>=this.num*4) {  
                System.out.println("B"+this.count);
                break;
            }
            this.strbf[count] = 'B';
            this.count++;
            this.index = 3;
            this.notifyAll();
        }
    }
    public synchronized  void appendC(){
        while(this.count<this.num*4) {
            while(this.index!=3){
                if(this.count>=this.num*4) {   
                    break;
                }
                try{
                   this.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            if(this.count>=this.num*4) {  
                System.out.println("C"+this.count);
                break;
            }
            this.strbf[count] = 'C';
            this.count++;
            this.index = 4;
            this.notifyAll();
        }
    }
    public  synchronized void appendD(){
        while(this.count<this.num*4) {
            while(this.index!=4){
                if(this.count==this.num*4) {   
                    break;
                }
                try{
                   this.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            if(this.count==this.num*4) {  
                System.out.println("D"+this.count);
                break;
            }
            this.strbf[count] = 'D';
            this.count++;
            this.index = 1;
            this.notifyAll();
        }
    }
}
 
class trdA implements Runnable{
    private Msg msg = null;
    public trdA(Msg msg){
        this.msg = msg;
    }
    public void run(){
        this.msg.appendA();
    }
}
 
class trdB implements Runnable{
    private Msg msg = null;
    public trdB(Msg msg){
        this.msg = msg;
    }
    public void run(){
        this.msg.appendB();
    }
}
 
class trdC implements Runnable{
    private Msg msg = null;
    public trdC(Msg msg){
        this.msg = msg;
    }
    public void run(){
        this.msg.appendC();
    }
}
 
class trdD implements Runnable{
    private Msg msg = null;
    public trdD(Msg msg){
        this.msg = msg;
    }
    public void run(){
        this.msg.appendD();
    }
}
 
public class Main13{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);//第一步，获取输入的参数
        Msg msg = null;
        while(sc.hasNext()){
            int num = sc.nextInt();
            msg = new Msg(num);
            Thread t1 = new Thread(new trdA(msg));
            t1.start();
            Thread t2 = new Thread(new trdB(msg));
            t2.start();
            Thread t3 = new Thread(new trdC(msg));
            t3.start();
            Thread t4 = new Thread(new trdD(msg));
            t4.start();
 
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("t1:"+t1.isAlive());
            System.out.println("t2:"+t2.isAlive());
            System.out.println("t3:"+t3.isAlive());
            System.out.println("t4:"+t4.isAlive());
            System.out.println(Thread.currentThread().getName());
             
        }
    }
}