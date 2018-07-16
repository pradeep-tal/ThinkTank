package com.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ProcessFiles {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newCachedThreadPool();

		List<String> files = new ArrayList<>();

		List<Future<Integer>> futures = new ArrayList<>();

		for (String file : files) {

			futures.add(executorService.submit(new progThread(file)));
		}

		executorService.shutdown();

		int validFiles = 0;

		try {
			executorService.awaitTermination(10, TimeUnit.MINUTES);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		for (Future<Integer> f : futures) {

			try {
				int val = f.get();
				if (val == 1)
					validFiles++;

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		System.out.println(validFiles);

	}

	static class progThread implements Callable<Integer> {

		private String file;

		public progThread(String file) {

			this.file = file;

		}

		@Override
		public Integer call() throws Exception {
			// Call method

			if (checkValid(file)) {
				return 1;
			} else {
				return 0;
			}

		}

		private boolean checkValid(String file2) {
			return false;
		}

	}

}
