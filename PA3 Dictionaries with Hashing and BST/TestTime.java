package PA3;

import java.util.Random;

public class TestTime {

	/**
	 * Sieve of Eratosthenes method for generating primes
	 */
	private static int getLargestBoundedPrime(int n) {

		boolean prime[] = new boolean[n + 1];
		for (int i = 0; i < n; i++)
			prime[i] = true;

		for (int p = 2; p <= Math.sqrt(n); p++) {
			if (prime[p]) {
				// Update all multiples of p
				for (int i = p * 2; i <= n; i += p)
					prime[i] = false;
			}
		}

		// Get Largest Prime <= n
		for (int i = n; i >= 2; i--) {
			if (prime[i])
				return i;
		}
		return 2;
	}

	public static void compareHashingAndBST() throws Exception {
		System.out.println("****************** Time Test Dictionary ******************\n");
		int U = 1000000;
		int TABLE_SIZE = getLargestBoundedPrime(U / 10);
		Random rand = new Random(0);
		Hashing hChain = new Hashing(TABLE_SIZE);
		BST bst = new BST();

		long totalHashIns = 0, totalBSTIns = 0;
		long totalHashSearch = 0, totalBSTSearch = 0;
		long totalHashDel = 0, totalBSTDel = 0;

		int generatedNum[] = new int[U];

		int numFailedInsertions = 0;
		for (int i = 0; i < U; i++) {
			int val = rand.nextInt(U);
			generatedNum[i] = val;
			long startTime = System.currentTimeMillis();
			boolean inserted = hChain.insert(val);
			if (!inserted)
				numFailedInsertions++;
			totalHashIns += System.currentTimeMillis() - startTime;

			startTime = System.currentTimeMillis();
			if (bst.insert(val) != null && !inserted)
				throw new Exception("Something wrong with insertion!");
			totalBSTIns += System.currentTimeMillis() - startTime;
		}

		int numFailedSearches = 0;
		for (int i = 0; i < U; i++) {
			int val = rand.nextDouble() > 0.5 ? rand.nextInt(U) : generatedNum[rand.nextInt(U)];

			long startTime = System.currentTimeMillis();
			boolean found = hChain.search(val);
			if (!found)
				numFailedSearches++;
			totalHashSearch += System.currentTimeMillis() - startTime;

			startTime = System.currentTimeMillis();
			if (null != bst.search(val) && !found)
				throw new Exception("Something wrong with search!");
			totalBSTSearch += System.currentTimeMillis() - startTime;
		}

		int numFailedDeletions = 0;
		for (int i = 0; i < U; i++) {
			int val = rand.nextDouble() > 0.5 ? rand.nextInt(U) : generatedNum[rand.nextInt(U)];

			long startTime = System.currentTimeMillis();
			boolean deleted = hChain.remove(val);
			if (!deleted)
				numFailedDeletions++;
			totalHashDel += System.currentTimeMillis() - startTime;

			startTime = System.currentTimeMillis();
			if (bst.remove(val) && !deleted)
				throw new Exception("Something wrong with deletion!");
			totalBSTDel += System.currentTimeMillis() - startTime;
		}

		System.out.println("*** Hashing ***\n");
		hChain.printStatistics();
		System.out.println("Total time over " + U + " insertion attempts (" + numFailedInsertions + " failed): "
				+ totalHashIns + " (may vary with each execution)");
		System.out.println("Total time over " + U + " search attempts (" + numFailedSearches + " failed): "
				+ totalHashSearch + " (may vary with each execution)");
		System.out.println("Total time over " + U + " deletion attempts (" + numFailedDeletions + " failed): "
				+ totalHashDel + " (may vary with each execution)");

		System.out.println("\n*** BST ***\n");
		System.out.println("Height of BST = " + bst.getHeight());
		System.out.println("Total time over " + U + " insertion attempts (" + numFailedInsertions + " failed): "
				+ totalBSTIns + " (may vary with each execution)");
		System.out.println("Total time over " + U + " search attempts (" + numFailedSearches + " failed): "
				+ totalBSTSearch + " (may vary with each execution)");
		System.out.println("Total time over " + U + " deletion attempts (" + numFailedDeletions + " failed): "
				+ totalBSTDel + " (may vary with each execution)");
	}

	public static void main(String[] args) throws Exception {
		compareHashingAndBST();
	}
}
