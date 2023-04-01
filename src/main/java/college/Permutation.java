package college;

import java.util.Scanner;

public class Permutation {
  public static void main(String[] args) {
    int totalObjects;
    int selectObject;
    int permutation;
    int f1;
    int f2;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the value of n and r");
    totalObjects = sc.nextInt();
    selectObject = sc.nextInt();
    f1 = totalObjects;
    for (int i = totalObjects; i >= 1; i--) {
      f1 = f1 * i;
    }
    int number;
    number = totalObjects - selectObject;
    f2 = number;
    for (int i = number - 1; i >= 1; i--) {
      f2 = f2 * i;
    }
    permutation = f1 / f2;
    System.out.println("The permutation of p(n,r)= " + permutation);
  }
}
