package others.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by engry on 2018/4/18.
 */
public class CallableThreadTest implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for(; i < 10; i ++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }
    public static void main(String[] args) {
        CallableThreadTest ctt = new CallableThreadTest();
        FutureTask<Integer> ft = new FutureTask<>(ctt);
        for (int i = 0; i < 10; i ++) {
            System.out.println(Thread.currentThread().getName() + "'s loop value i = " + i);
            if (i == 2) {
                new Thread(ft, "Thread_With_Returned_Value").start();
            }
        }

        try {
            System.out.println("child thread's returned value: " + ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
