package task4;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FibonacciSum implements Callable<Integer> {
    List<Integer> list ;
    String name;
    int size;

    public FibonacciSum(int size,String name) {
        this.size = size;
        this.name = name;
        list = new ArrayList<>(size);
    }

    public int fib(int n){
        if(n < 2){
            list.add(n);
            return n;
        }
        else{
            int f = list.get(n-2)+list.get(n-1);
            list.add(f);
            return f;
        }

    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i = 0;i < size; i++){
            sum += fib(i);
        }
        System.out.println("Fibonacci "+name+" :"+list);

        return sum;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<FibonacciSum> callables = Arrays.asList(new FibonacciSum(10,"LoL1"),new FibonacciSum(6,"LOL2"),
                new FibonacciSum(10,"LOL3"));
        System.out.println("sum : "+executor.submit(new FibonacciSum(10,"fib1")).get());

    }
}
