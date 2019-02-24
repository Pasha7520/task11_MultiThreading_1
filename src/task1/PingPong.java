package task1;

public class PingPong {
        private static Object sync = new Object(); // Monitor
        public void show() {
            Thread t1 = new Thread(() -> {
                synchronized (sync) {
                    while (true) {
                        try {
                            sync.wait();
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                        }
                        System.out.println("ping!");

                        sync.notify();
                    }
                }
            });
            Thread t2 = new Thread(() -> {
                synchronized (sync) {
                    while (true) {
                        sync.notify();
                        try {
                            sync.wait();
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                        }
                        System.out.println("pong!");
                    }
                }
            });
            t1.start();
            t2.start();
        }
}
