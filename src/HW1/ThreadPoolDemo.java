package HW1;


import sun.jvm.hotspot.opto.Block;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

public class ThreadPoolDemo {
    private int size;

}

class ThreadPool {
    private int size = 4;
    private int queueSize = 100;
    private BlockingQueue<Runnable> taskQueue;
    private Thread[] threads;

    class WorkThread extends Thread {
        @Override
        public void run() {
            Runnable r;
            try {
                while(! isInterrupted()) {
                    r = taskQueue.take();
                }
            } catch (InterruptedException e) {

            }
        }

        public void stopWorker() {
            interrupt();
        }
    }

    public ThreadPool() {
        threads = new WorkThread[size];
        for (int i = 0; i < size; i++) {
            threads[i].start();
        }
    }

    public void destroy() {
        for (int i = 0; i < size; i++) {
//            threads[i].stopWorker();
            threads[i] = null;
        }
        taskQueue.clear();
    }
}


