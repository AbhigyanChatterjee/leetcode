public class Problem14 {

  class Trie {
    public final static int CHAR_SET_SIZE = 26;

    private Node root;

    /** Initialize data structure here. */
    public Trie() {
      root = new Node('0');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
      assert word != null;
      int n = word.length();
      Node curr = root;
      for (int i = 0; i < n; i++) {
        char c = word.charAt(i);
        Node next = curr.getNode(c);
        if (next == null) {
          curr.insertNode(c);
          next = curr.getNode(c);
        }
        curr = next;
      }
      curr.setWord(true);
      return;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
      assert word != null && word.length() != 0;
      int n = word.length();
      Node curr = root;
      for (int i = 0; i < n; i++) {
        char c = word.charAt(i);
        curr = curr.getNode(c);
        if (curr == null)
          return false;
      }
      return curr.isWord();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
      assert prefix != null && prefix.length() != 0;
      int n = prefix.length();
      Node curr = root;
      for (int i = 0; i < n; i++) {
        char c = prefix.charAt(i);
        curr = curr.getNode(c);
        if (curr == null)
          return false;
      }
      return true;
    }

    private class Node {
      private Node[] mapping;
      private boolean word;

      Node(char c) {
        this.mapping = new Node[CHAR_SET_SIZE];
        this.word = false;
      }

      void setWord(boolean isWord) {
        this.word = isWord;
      }

      boolean isWord() {
        return this.word;
      }

      Node insertNode(char c) {
        int ci = c - 'a';
        assert ci >= 0 && ci < CHAR_SET_SIZE;
        if (mapping[ci] == null) {
          this.mapping[ci] = new Node(c);
        }
        return this.mapping[ci];
      }

      Node getNode(char c) {
        int ci = c - 'a';
        assert ci >= 0 && ci < CHAR_SET_SIZE;
        return this.mapping[ci];
      }
    }
  }
}

/**
 * Trie object will be instantiated and called as such: Trie obj = new Trie();
 * obj.insert(word); boolean param_2 = obj.search(word); boolean param_3 =
 * obj.startsWith(prefix);
 */
