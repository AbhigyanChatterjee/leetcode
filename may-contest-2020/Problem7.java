import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem7 {
  public boolean isCousins(TreeNode root, int x, int y) {
    if (x == root.val || y == root.val)
      return false;
    Set<Integer> seen = new HashSet<>();
    Set<Integer> cousins = new HashSet<>();
    cousins.add(x);
    cousins.add(y);
    List<Data> allCousins = traverse(root, seen, cousins, 0, null);
    for (int i = 0; i < allCousins.size() - 1; i++) {
      if (allCousins.get(i).parent == allCousins.get(i + 1).parent
          || allCousins.get(i).level != allCousins.get(i + 1).level)
        return false;
    }
    return true;
  }

  private List<Data> traverse(TreeNode node, Set<Integer> seen, Set<Integer> cousins, int level, TreeNode parent) {
    List<Data> list = new ArrayList<Data>();
    if (node == null)
      return list;
    if (cousins.contains(node.val) && !seen.contains(node.val)) {
      Data data = new Data(parent, level);
      list.add(data);
      seen.add(node.val);
    }

    list.addAll(traverse(node.left, seen, cousins, level + 1, node));
    list.addAll(traverse(node.right, seen, cousins, level + 1, node));

    return list;
  }

  private class Data {
    TreeNode parent;
    int level;

    Data(TreeNode parent, int level) {
      this.parent = parent;
      this.level = level;
    }
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
