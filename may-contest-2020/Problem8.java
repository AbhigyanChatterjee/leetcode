public class Problem8 {
  public boolean checkStraightLine(int[][] coordinates) {
    int n = coordinates.length;
    for (int i = 2; i < n; i++) {
      if (!inStraightLine(coordinates[i - 2], coordinates[i - 1], coordinates[i]))
        return false;
    }

    return true;
  }
  
  private boolean inStraightLine(int[] p1, int[] p2, int[] p3) {
    // (x1, y2), (x2, y2), (x3, y3) are in straight line if
    // (y3 - y2) * (x2 - x1) == (y2 - y1) * (x3 - x2)
    return ((p3[1] - p2[1]) * (p2[0] - p1[0])) == ((p2[1] - p1[1]) * (p3[0] - p2[0]));
  }
}
