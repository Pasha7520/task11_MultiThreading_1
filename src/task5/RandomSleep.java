package task5;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.*;

public class RandomSleep extends Thread{
    private int number;
    public RandomSleep(int number) {
        this.number = number;

    }
    @Override
    public void run(){
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(number);
        System.out.println("Start : "+ LocalTime.now());
        for(int i=0;i < number;i++){
        int random = rand();
        Runnable task = () -> {
            System.out.println("    Scheduling sleeping: " + random + " second."+"Wake up: "+ LocalTime.now());

        };
        executor.schedule(task,random,TimeUnit.SECONDS);

        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("End : "+LocalTime.now());
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
            RandomSleep randomSleep = new RandomSleep(3);
            randomSleep.start();
    }
    public static int rand(){
        return new Random().nextInt((10-1)+1);
    }

}
