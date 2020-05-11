import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem10 {
  public int findJudge(int N, int[][] trusts) {
    if (trusts.length == 0)
      return N;
    // Incoming edges
    Map<Integer, Set<Integer>> incoming = new HashMap<>();
    // Outgoing edges
    Map<Integer, Set<Integer>> outgoing = new HashMap<>();

    for (int[] trust : trusts) {
      int from = trust[0], to = trust[1];
      Set<Integer> out = outgoing.containsKey(from) ? outgoing.get(from) : new HashSet<>();
      Set<Integer> in = incoming.containsKey(to) ? incoming.get(to) : new HashSet<>();
      out.add(to);
      in.add(from);
      outgoing.put(from, out);
      incoming.put(to, in);
    }

    int judge = -1;

    Set<Integer> trustsNoOne = new HashSet<>();
    for (int l = 1; l <= N; l++) {
      if (!outgoing.containsKey(l) || outgoing.get(l).isEmpty())
        trustsNoOne.add(l);
    }

    for (int j : trustsNoOne) {
      if (incoming.containsKey(j) && incoming.get(j).size() == N - 1 && !incoming.get(j).contains(j))
        return j;
    }

    return judge;
  }
}
