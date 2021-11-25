package ua.goit.javacore4.HW12;

import java.lang.annotation.Annotation;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolExecutor extends ThreadPoolExecutor {
    private static BlockingDeque<Runnable> workQueue = new LinkedBlockingDeque<>();

    public MyThreadPoolExecutor(int count) {
        super(count, count + 5, 100, TimeUnit.MILLISECONDS, workQueue);
    }

    @Override
    public void execute(Runnable runnable) {
        int count = 1;
        if (runnable.getClass().isAnnotationPresent(Repeat.class)) {
            count = runnable.getClass().getAnnotation(Repeat.class).value();
        }
        for (int i = 0; i < count; i++) {
            super.execute(runnable);
        }
    }
}
