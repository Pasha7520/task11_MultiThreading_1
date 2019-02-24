package task7;

import java.time.LocalDateTime;
import java.util.Scanner;

class Сompetition {
    private static Pipe<String> sync = new Pipe<>();
    public void show() {
        Thread t1 = new Thread(() -> {
            String massage = null;
            synchronized (sync) {
                while (true) {
                   // if(sync.take().equals(null))
                    try {
                        sync.wait();
                    } catch (InterruptedException e) {
                    }
                    try {
                        massage = new Scanner(System.in).nextLine();
                        sync.put(massage);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sync.notify();
                    System.out.println("sending " + massage);
                }

            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (sync) {
                for (int i = 1; i <= 10000000; i++) {
                    sync.notify();
                    try {
                        sync.wait();
                    } catch (InterruptedException e) {
                    }

                }
                System.out.println("finish " + Thread.currentThread().getName());
            }
        });
        System.out.println(LocalDateTime.now());
        t1.start();
        t2.start();
        try { t1.join(); t2.join();
        } catch (InterruptedException e) { }
        System.out.println(LocalDateTime.now());
      //  System.out.println("A=" + A);
    }
}