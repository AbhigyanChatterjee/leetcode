public class Problem1 extends VersionControl {
  public int firstBadVersion(int n) {
    int lo = 1, hi = n;
    int badV = Integer.MAX_VALUE;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (isBadVersion(mid)) {
            badV = Math.min(badV, mid);
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }
    return badV;
  }
}

class VersionControl {
  // Dummy code for sucessful compilation
  public boolean isBadVersion(int n) {
    return false;
  }
}
