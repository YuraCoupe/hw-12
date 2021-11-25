package ua.goit.javacore4.HW12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class H2ODemo {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        H2O h2o = new H2O();

        for(int i = 0; i < 7; i++) {
            threadPool.execute(new Thread(() -> h2o.hydrogen(() -> System.out.print("H"))));
            threadPool.execute(new Thread(() -> h2o.hydrogen(() -> System.out.print("H"))));
            threadPool.execute(new Thread(() -> h2o.oxygen(() -> System.out.print("O"))));
        }

        threadPool.shutdown();
    }

}
