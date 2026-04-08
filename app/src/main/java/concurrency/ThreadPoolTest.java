package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolTest {
    static void main() throws ExecutionException, InterruptedException {
        try (ExecutorService service = Executors.newFixedThreadPool(5)) {
            List<Future<String>> list = new ArrayList<>(5);

            for (int i = 0; i < 5; i++) {
                Future<String> future = service.submit(() -> Thread.currentThread().getName() + ":hello world");

                list.add(future);
            }

            for (Future<String> future : list) {
                System.out.println(future.get());
            }
        }
    }
}
