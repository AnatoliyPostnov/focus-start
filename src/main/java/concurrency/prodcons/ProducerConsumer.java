package concurrency.prodcons;

import java.util.concurrent.Semaphore;

public class ProducerConsumer {

    private int count = 0;

    Semaphore sem = new Semaphore(1);

    public void produce() throws InterruptedException {
        while (true) {
            sem.acquire();
            if ( count < 9) {
                System.out.println(Thread.currentThread().getName() + " " + count++ + " ");
                Thread.sleep(500);
            }
            sem.release();
        }
    }


    public void consume() throws InterruptedException {
        while (true) {
            sem.acquire();
            if (count > 1) {
                System.out.println(Thread.currentThread().getName() + " " + count--);
                Thread.sleep(500);
            }
            sem.release();
        }
    }
}

