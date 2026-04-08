package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


public class CallableTest {
    static void main() throws Exception {
        MyThread mt = new MyThread();

        FutureTask<Integer> result = new FutureTask<>(mt);

        new Thread(result).start();

        Integer sum = result.get();

        System.out.println(sum);
    }
}

class MyThread implements Callable<Integer> {
    @Override
    public Integer call() {
        int sum = 0;

        for (int i = 1; i <= 100; i++) {
            sum += i;
        }

        return sum;
    }
}