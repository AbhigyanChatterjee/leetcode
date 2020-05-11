public class Problem11 {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    if (image == null || image.length == 0 || image[0].length == 0)
      return image;
    int m = image.length, n = image[0].length;
    int oldCol = image[sr][sc];
    floodFill(image, sr, sc, newColor, oldCol, m, n);
    return image;
  }

  private void floodFill(int[][] image, int r, int c, int newColor, int oldColor, int m, int n) {
    if (r < 0 || r >= m || c < 0 || c >= n)
      return;
    if (image[r][c] != oldColor || image[r][c] == newColor)
      return;

    image[r][c] = newColor;
    floodFill(image, r + 1, c, newColor, oldColor, m, n);
    floodFill(image, r - 1, c, newColor, oldColor, m, n);
    floodFill(image, r, c + 1, newColor, oldColor, m, n);
    floodFill(image, r, c - 1, newColor, oldColor, m, n);
    return;
  }
}
