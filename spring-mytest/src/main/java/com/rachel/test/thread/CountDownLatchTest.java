package com.rachel.test.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(3);
		final CountDownLatch latch = new CountDownLatch(3);
		for (int i = 0; i < 3; i++) {
			Runnable runnable = () -> {
				try {
					System.out.println("child thrad" + Thread.currentThread().getName() + " start running");
					Thread.sleep((long) (Math.random() * 10000));
					System.out.println("child thrad"+Thread.currentThread().getName()+" run completely");
					latch.countDown();//当前线程调用此方法，则计数减一
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
			service.execute(runnable);
		}

		try {
			System.out.println("main thread"+Thread.currentThread().getName()+" waiting for completion of child threads...");
			latch.await();//阻塞当前线程，直到计数器的值为0
			System.out.println("main thread"+Thread.currentThread().getName()+"start running...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
