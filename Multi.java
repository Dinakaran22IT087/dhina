import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
class  TollGate{
    public void passCar(String carName){
        System.out.println(carName+" is paying toll");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(carName+" had passed the toll");
    }
}
class Car extends Thread{
    private String carName;
    private TollGate toll;
    private CountDownLatch gateOpen;
    public Car(String carName,TollGate toll,CountDownLatch gateOpen){
        this.carName=carName;
        this.toll=toll;
        this.gateOpen=gateOpen;
    }

public void run(){
    System.out.println(carName+"is waiting for gate to open");
    try {
        gateOpen.await();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    toll.passCar(carName);
}
}
public class Multi{
    public static void main(String[] args)throws InterruptedException {
        
        Scanner joy =new Scanner(System.in);
        TollGate toll=new TollGate();
        CountDownLatch gateSignal=new CountDownLatch(1);
        Car c1=new Car("xxx",toll,gateSignal);
        Car c2=new Car("yyy",toll,gateSignal);
        c1.start();
        c2.start();
        Thread.sleep(2000);
        System.out.println("Toll gate is open now");
        gateSignal.countDown();
    }
}