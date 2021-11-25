package ua.goit.javacore4.HW12;

public class MyThreadExecutorDemo {
    public static void main(String[] strings) {
        MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(10);
        myThreadPoolExecutor.execute(new MyRunnable());
        myThreadPoolExecutor.shutdown();
    }
}

@Repeat(3)
class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello!");
    }
}