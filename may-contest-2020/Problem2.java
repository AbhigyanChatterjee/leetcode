import java.util.HashSet;
import java.util.Set;

public class Problem2 {
  public int numJewelsInStones(String J, String S) {
    Set<Character> set = new HashSet<>();
    int matching = 0;
    for (int i = 0; i < J.length(); i++) set.add(J.charAt(i));
    for (int i = 0; i < S.length(); i++) {
      matching += set.contains(S.charAt(i)) ? 1 : 0;
    }
    return matching;
  }
}
