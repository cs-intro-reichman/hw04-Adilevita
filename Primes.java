public class Primes {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean[] isPrime = sieve(n);

        System.out.println("Prime numbers up to " + n + ":");

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i);
                count++;
            }
        }

        double percent = (100.0 * count) / n;
        System.out.println("There are " + count + " primes between 2 and " + n + " (" + (int) percent + "% are primes)");
    }

    public static boolean[] sieve(int n) {

        boolean[] isPrime = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        int p = 2;
        while (p * p <= n) {
            if (isPrime[p]) {
                int multiple = p * p;
                while (multiple <= n) {
                    isPrime[multiple] = false;
                    multiple += p;
                }
            }
            p++;
        }
        return isPrime;
    }
}
