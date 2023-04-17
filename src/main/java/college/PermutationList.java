package college;

import java.util.ArrayList;
import java.util.List;

public class PermutationList {
  public List<String> findPermutations(String word) {
    List<String> storeList = new ArrayList<>();
    char[] wordArr = word.toCharArray();
    findPermutationsHelper(wordArr, 0, storeList);
    return storeList;
  }

  private void findPermutationsHelper(char[] wordArr, int index, List<String> permutations) {
    if (index == wordArr.length - 1) {
      permutations.add(new String(wordArr));
    } else {
      for (int i = index; i < wordArr.length; i++) {
        swap(wordArr, index, i);
        findPermutationsHelper(wordArr, index + 1, permutations);
        swap(wordArr, index, i); // Backtrack to restore original order
      }
    }
  }

  private void swap(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    String word = "abc";
    PermutationList permutations = new PermutationList();
    List<String> result = permutations.findPermutations(word);
    System.out.println("PermutationList of " + word + ": " + result);
  }
}
