package HW1;

public class ReadWriteLock {
    private int readcount = 0;
    private int writecount = 0;

    public synchronized void lockRead() throws InterruptedException {
        while (writecount > 0) {
            this.wait();
        }
        readcount++;
    }

    public synchronized void releaseRead() {
        readcount--;
        notifyAll();
    }

    public synchronized void lockWrite() throws InterruptedException {
        while (writecount > 0) {
            this.wait();
        }
        writecount++;
        while (readcount > 0) {
            this.wait();
        }
    }

    public synchronized void releaseWrite() {
        writecount--;
        notifyAll();
    }
}


