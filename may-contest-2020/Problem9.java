public class Problem9 {
  public boolean isPerfectSquare(int num) {
    int lo = 1, hi = num;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (mid > Integer.MAX_VALUE / mid) {  // Check for overflow of square
        hi = mid - 1;
        continue;
      }
      int sq = mid * mid;
      if (sq == num)
        return true;
      else if (sq > num)
        hi = mid - 1;
      else
        lo = mid + 1;
    }
    return false;
  }
}
