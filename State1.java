import java.io.BufferedReader;
import java.io.InputStreamReader;

public class State1 {

  // aabcccbbad
  public static void main(String[] args) throws Exception {
    try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
      String input = in.readLine();
      char[] chars = input.toCharArray();

      boolean found = false;
      do {
        StringBuilder builder = new StringBuilder();
        int times = 0;
        found = false;

        char prevChar = '\n';
        for (char c : chars) {
          if (prevChar == c) {
            times++;

          } else {
            if (append(builder, prevChar, times)) {
              found = true;
            }

            times = 1;
            prevChar = c;
          }
        }

        append(builder, prevChar, times);
        System.out.println(builder);
        chars = builder.toString().toCharArray();

      } while (found && chars.length > 3);
    }
  }

  private static boolean append(StringBuilder builder, char prevChar, int times) {
    if (times >= 3) {
      return true;

    } else {
      for (int loop = 0; loop < times; loop++) {
        builder.append(prevChar);
      }
    }

    return false;
  }

}
