public class ConcurrencyClass extends Thread {
    @Override
    public void run() {
        printSomethingSync();
    }

    private synchronized void printSomethingSync() {
        System.out.println("This method is synchronized. Inside thread: "
                + Thread.currentThread().getName());
    }

}
