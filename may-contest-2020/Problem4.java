public class Problem4 {
  public int findComplement(int num) {
    assert num > 0;
    int ans = 0, i = 0;
    while (num > 0) {
      int o = num & 1;
      ans += (o == 0 ? 1 : 0) << i;
      i++;
      num = num >> 1;
    }
    return ans;
  }
}
