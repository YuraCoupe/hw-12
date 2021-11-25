package ua.goit.javacore4.HW12;

import java.util.concurrent.*;

public class H2O {
    private final Semaphore h = new Semaphore(2);
    private final Semaphore o = new Semaphore(1);
    private final CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> System.out.print(" "));

    public void hydrogen(Runnable releaseHydrogen) {
        try {
            h.acquire();
            cyclicBarrier.await();
            releaseHydrogen.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            h.release();
        }
    }

    public void oxygen(Runnable releaseOxygen) {
        try {
            o.acquire();
            cyclicBarrier.await();
            releaseOxygen.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            o.release();
        }
    }

}

