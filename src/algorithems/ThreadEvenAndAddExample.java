package algorithems;

public class ThreadEvenAndAddExample implements Runnable {

    static int counter = 1;

    private Object object;

    public ThreadEvenAndAddExample(Object object) {
        this.object = object;
    }

    @Override
    public void run() {

        while (counter <= 10) {
            synchronized (object) {
                if ((counter % 2 == 0) && Thread.currentThread().getName().equals("even")) {
                    System.out.println("Thread Name " + Thread.currentThread().getName() + " value is :" + counter);
                    counter++;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                if ((counter % 2 != 0) && Thread.currentThread().getName().equals("odd")) {
                    System.out.println("Thread Name " + Thread.currentThread().getName() + " value is :" + counter);
                    counter++;
                    object.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        Runnable r1 = new ThreadEvenAndAddExample(lock);
        Runnable r2 = new ThreadEvenAndAddExample(lock);
        new Thread(r1,"even").start();
        new Thread(r2, "odd").start();
    }


}

