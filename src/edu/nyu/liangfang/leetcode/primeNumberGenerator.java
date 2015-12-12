package edu.nyu.liangfang.leetcode;

public class primeNumberGenerator {
	public boolean[] sieveOfEratosthenes(int max) {
		boolean[] primes = new boolean[max + 1];
		
		// initial all number to true other than 0 and 1
		primes[0] = false;
		primes[1] = false;
		for (int i = 2; i<= max; i++) {
			primes[i] = true;
		}
		
		int prime = 2;
		while (prime < Math.sqrt(max)) {
			/* corss off remaining multiples of prime. We can start with
			 * prime*prime, since if we have k*prime and k < prime, this
			 * value would have already been crossed off in prior iteration
			 */
			for (int i = prime * prime; i < max + 1; i += prime) {
				primes[i] = false;
			}
			
			// get next prime (non-corss off number)
			prime++;
			if (prime < max + 1 && !primes[prime]) {
				prime++;
			}
			
			if (prime >= max + 1) {
				break;
			}
		}
		
		for (int i = 0; i <= max; i++) {
			if (primes[i]) {
				System.out.println(i);
			}
		}
		
		return primes;
	}
}
