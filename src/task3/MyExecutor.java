package task3;

import task2.MyFibonacci;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyExecutor {
    void goo(ExecutorService executorService, int n) {
        for (int i = 1; i <= n; i++) {
            executorService.execute(new MyFibonacci(i));

        }
        executorService.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        MyExecutor myExecutor = new MyExecutor();
        System.out.println("CachedThreadPool");
        myExecutor.goo(Executors.newCachedThreadPool(),12);
        Thread.sleep(999);
        System.out.println("SingleThread");
        myExecutor.goo(Executors.newSingleThreadExecutor(),6);
        Thread.sleep(999);
        myExecutor.goo(Executors.newFixedThreadPool(10),7);
    }

}
