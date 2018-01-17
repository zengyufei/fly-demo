package 线程中断测试;

public class ThreadTest {

    static class ThreadSub extends Thread {
        @Override
        public void run() {
            while (true) {
                if (Thread.interrupted()) {
                    System.out.println("线程中断");
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadSub threadSub = new ThreadSub();
        threadSub.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadSub.interrupt();
    }

}
