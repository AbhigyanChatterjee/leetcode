public class Problem6 {
  public int majorityElement(int[] nums) {
    assert nums != null && nums.length > 0;
    int n = nums.length;
    int maj = nums[0], countMaj = 1;
    for (int i = 1; i < n; i++) {
      if (nums[i] != maj) {
        countMaj--;
      } else {
        countMaj++;
      }
      // If net count = 0, then the last element seen
      // is a potential majority element
      if (countMaj == 0) {
        maj = nums[i];
        countMaj = 1;
      }
    }
    return maj;
  }
}
