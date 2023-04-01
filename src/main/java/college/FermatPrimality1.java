package college;

import java.util.Random;
import java.util.Scanner;

public class FermatPrimality1 {
  public boolean isPrime(long n, int iteration) {
    if (n == 0 || n == 1) return false;
    if (n == 2) return true;
    if (n % 2 == 0) return false;

    Random rand = new Random();
    for (int i = 0; i < iteration; i++) {
      long r = Math.abs(rand.nextLong());
      long a = r % (n - 1) + 1;
      if (modPow(a, n - 1, n) != 1) return false;
    }
    return true;
  }

  public long modPow(long a, long b, long c) {
    long res = 1;
    for (int i = 0; i < b; i++) {
      res *= a;
      res %= c;
    }
    return res % c;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Fermat Primality Algorithm Test\n");

    FermatPrimality1 fp = new FermatPrimality1();

    System.out.println("Enter number\n");
    long num = scan.nextLong();

    System.out.println("\nEnter number of iterations");
    int k = scan.nextInt();

    scan.close();
    boolean prime = fp.isPrime(num, k);
    if (prime) System.out.println("\n" + num + " is prime");
    else System.out.println("\n" + num + " is composite");
  }
}
