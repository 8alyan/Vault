package labreport;

public class PatternMatching {
       public static void naivePatternMatch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
     for (int i = 0; i <= n - m; i++) {
            int j = 0;
     while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
                j++;  }
            if (j == m) {
                System.out.println("Pattern found at index: " + i);
            }
        }
    }
public static void main(String[] args) {
        String text = "ABABABACDABABCABABABACDAB";
        String pattern = "ABABCABAB";
   System.out.println("Searching for pattern: \"" + pattern + "\" in text: \"" + text + "\"");
  naivePatternMatch(text, pattern);
    }
} 