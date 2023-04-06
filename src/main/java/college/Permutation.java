package college;

public class Permutation {
  public static void main(String[] args) {
    String str = "ABC";
    int n = str.length();
    Permutation permutation = new Permutation();
    permutation.permute(str, 0, n - 1);
  }
  /* Permutation function @param str
  string to calculate permutation
  for @param l starting index
  @param r end index */
  private void permute(String str, int l, int r) {
    if (l == r) System.out.println(str);
    else {
      for (int i = l; i <= r; i++) {
        str = swap(str, l, i);
        permute(str, l + 1, r);
        str = swap(str, l, i);
      }
    }
  }
  /* Swap Characters at position
  @param a string value @param
  i position 1 @param j position 2
  @return swapped string */
  public String swap(String a, int i, int j) {
    char temp;
    char[] charArray = a.toCharArray();
    temp = charArray[i];
    charArray[i] = charArray[j];
    charArray[j] = temp;
    return String.valueOf(charArray);
  }
}

/* import java.util.Scanner;

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
} */
