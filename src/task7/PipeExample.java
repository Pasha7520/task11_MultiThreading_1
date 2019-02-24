package task7;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Scanner;

public class PipeExample {


        public static void main(String[] args) throws IOException {

            final PipedOutputStream output = new PipedOutputStream();

            final PipedInputStream  input  = new PipedInputStream();
            output.connect(input);


            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            output.write(new Scanner(System.in).nextLine().getBytes());

                        }
                    } catch (IOException e) {
                    }
                }
            });


            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        int data = input.read();
                        while(data != -1){
                            System.out.print((char) data);
                            data = input.read();
                        }

                    } catch (IOException e) {
                    }
                }
            });

            thread1.start();
            thread2.start();

        }

}
