package others.thread;

/**
 *
 */
class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;

    ThreadDemo(String name) {
        threadName = name;
        System.out.println("Creating thread " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupte.");
        }
        System.out.println("Thread " + threadName + " exiting.");

    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

public class ThreadTest {
    public static void main(String args[]) {
        ThreadDemo r1 = new ThreadDemo("Thread-1");
        r1.start();

        ThreadDemo r2 = new ThreadDemo("Thread-2");
        r2.start();
    }
}
