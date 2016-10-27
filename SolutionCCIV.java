/**
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class SolutionCCIV {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) continue;
            count++;
            for (int j = i; j<n; j = j+i) {
                primes[j] = true;
            }
        }
        return count;
    }
}
