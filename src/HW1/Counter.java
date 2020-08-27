package HW1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class Counter {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedCounter c1 = new SynchronizedCounter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                c1.add();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                c1.dec();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        /* expect: 0 */
        System.out.println(c1.get());
    }
}

class SynchronizedCounter {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
    private int count = 0;

    public void add() {
        writeLock.lock();
        try {
            count++;
        } finally {
            writeLock.unlock();
        }
    }

    public void dec() {
        writeLock.lock();
        try {
            count--;
        } finally {
            writeLock.unlock();
        }
    }

    public int get() {
        readLock.lock();
        try {
            return count;
        } finally {
            readLock.unlock();
        }
    }
}
