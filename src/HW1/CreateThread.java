package HW1;

public class CreateThread {
    public static void main(String[] args) {
        /*  extends Thread class */
        Thread thread1 = new Thread1();
        thread1.start();
        /*  implements Runnable interface */
        Thread thread2 = new Thread(new myRunnable());
        thread2.start();
        /*  lambda */
        Thread thread3 = new Thread(() -> {
            System.out.println("Thread3 is running");
            System.out.println("Thread3 end");
        });
        thread3.start();
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        System.out.println("HW1.Thread1 is running");
        System.out.println("HW1.Thread1 end");
    }
}

class myRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread2 is running");
        System.out.println("Thread2 end");
    }
}