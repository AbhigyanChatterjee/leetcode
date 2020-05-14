import java.util.Stack;

public class Problem13 {
  public String removeKdigits(String num, int k) {
    assert k >= 0 && k <= num.length();
    int n = num.length();

    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      char c = num.charAt(i);
      while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
        stack.pop();
        k--;
      }
      stack.push(c);
    }

    // Remove remainder elements
    while (k-- > 0)
      stack.pop();

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty())
      sb.append(stack.pop());

    // Remove leading zeros
    // Appear from the last in sb because they have been popped off the stack
    // in reverse order
    while (sb.length() != 0 && sb.charAt(sb.length() - 1) == '0')
      sb.setLength(sb.length() - 1);

    sb.reverse();
    return sb.length() == 0 ? "0" : sb.toString();
  }
}
