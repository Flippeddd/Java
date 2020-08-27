package HW1;

public class SemaphoreDemo {
    public static void main(String[] args) {
        CountingSemaphore sem = new CountingSemaphore(1);
        MyThread t1 = new MyThread(sem, "A");
        MyThread t2 = new MyThread(sem, "B");
        t1.start();
        t2.start();
    }
}

class MyThread extends Thread {
    private CountingSemaphore sem;
    private String threadName;

    public MyThread (CountingSemaphore sem, String threadName) {
        this.sem =  sem;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println(threadName + " is running");
        System.out.println(threadName + " is waiting for perimit");
        try {
            sem.acquire();
        } catch (InterruptedException e) {}
        for (int i = 0; i < 3; i ++) {
            System.out.println(threadName + i);
        }
        sem.release();
        System.out.println(threadName + " releases permit");
    }
}


class CountingSemaphore {
    private final int SEM;
    private int count;

    public CountingSemaphore(int sem) {
        this.SEM = sem;
    }

    public synchronized void acquire() throws InterruptedException {
        while (count >= SEM) {
            this.wait();
        }
        count++;
    }

    public synchronized void release() {
        count--;
        notifyAll();
    }
}


