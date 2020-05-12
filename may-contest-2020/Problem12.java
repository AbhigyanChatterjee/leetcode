public class Problem12 {
  public int singleNonDuplicate(int[] nums) {
    int n = nums.length;
    assert (n & 1) == 1; // Odd cardinality
    int lo = 0, hi = n - 1;

    while (lo <= hi) {
      assert ((hi - lo + 1) & 1) == 1; // Odd cardinality
      if (lo == hi)
        return nums[lo];

      int mid = lo + (hi - lo) / 2;
      int prev = nums[mid - 1], next = nums[mid + 1];
      if (prev == nums[mid]) { // check size of left, if odd then number lies in left
        if ((mid - lo + 1) % 2 == 1)
          hi = mid;
        else
          lo = mid + 1;
      } else if (nums[mid] == next) {
        if ((hi - mid + 1) % 2 == 1)
          lo = mid;
        else
          hi = mid - 1;
      } else {
        return nums[mid];
      }
    }

    return -1;
  }
}
