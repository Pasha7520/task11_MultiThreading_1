package task2;

import java.util.ArrayList;
import java.util.List;

public class MyFibonacci extends Thread {
    List<Integer> list ;
    int size;

    public MyFibonacci(int size) {
        this.size = size;
        list = new ArrayList<>(size);
    }

    public void fib(int n){
        if(n < 2){
            list.add(n);
        }
        else{
            list.add(list.get(n-2)+list.get(n-1));
        }

    }

    @Override
    public void run(){
        for(int i = 0;i < size; i++){
            fib(i);
        }
        System.out.println("Fibonacci: "+list);
    }


    public static void main(String[] args) {
        MyFibonacci myFibonacci = new MyFibonacci(6);
        myFibonacci.start();
    }
}
