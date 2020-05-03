public class Problem3 {
  public boolean canConstruct(String ransomNote, String magazine) {
    int n = ransomNote.length(), m = magazine.length();
    int[] f = new int[26];
    for (int i = 0; i < m; i++) f[(int) (magazine.charAt(i) - 'a')]++;
    for (int i = 0; i < n; i++) {
      int offset = (int) (ransomNote.charAt(i) - 'a');
      f[offset]--;
      if (f[offset] < 0) return false;
    }
    return true;
  }
}
