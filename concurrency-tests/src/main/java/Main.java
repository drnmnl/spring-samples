import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Runnable runnable = new ConcurrencyClass();
        Thread thread1 = new Thread(runnable);
        thread1.start();

        Runnable runnable2 = ()-> {
            System.out.println("Inside thread: " + Thread.currentThread().getName());
        };

        Callable callable = () -> {
            return "Return string";
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(callable);
        executorService2.submit(runnable);
        ExecutorService executorService3 = Executors.newFixedThreadPool(2);
        executorService3.submit(runnable2);

        while(!future.isDone()) {
            System.out.println("Task is still not done...");
            Thread.sleep(200);
        }

        System.out.println("Task completed! Retrieving the result");
        String result = future.get();


        executorService.shutdown();
        executorService2.shutdown();
        executorService3.shutdown();
    }

}
