package algorithems;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class ThreadEvenAndAddExample8AnotherApproach {
    private static Object object = new Object();
    private static IntPredicate evenNumber = (i) -> i%2 == 0;
    private static IntPredicate oddNumber = (i) -> i%2 != 0;

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> ThreadEvenAndAddExample8AnotherApproach.printResults(oddNumber));
        CompletableFuture.runAsync(() -> ThreadEvenAndAddExample8AnotherApproach.printResults(evenNumber));
        Thread.sleep(1000);
    }

    public static void printResults(IntPredicate predicate){
        IntStream.rangeClosed(1,10).filter(predicate).forEach(ThreadEvenAndAddExample8AnotherApproach::execute);
    }

    public static void execute(int i){
        synchronized (object) {
            try{
                System.out.println( "Thread Name :" + Thread.currentThread().getName() + " value is :" + i);
                object.notify();
                object.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

