package labreport;

public class Spaces {
    public static void main(String[] args) {
        String input = "Hello Your Caption   Speaking    This  is  Flight   108768 The Weather   is  beautiful  Today ";
        int singleSpaceCount = 0;
        int doubleSpaceCount = 0;
        int multiSpaceCount = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                int spaceCount = 1;

                while (i + 1 < input.length() && input.charAt(i + 1) == ' ') {
                    spaceCount++;
                    i++;
                }
                if (spaceCount == 1) {
                    singleSpaceCount++;
                } else if (spaceCount == 2) {
                    doubleSpaceCount++;
                } else if (spaceCount > 2) {
                    multiSpaceCount++;
                }
            }
        }

        String result = input.replaceAll("\\s{2,}", " ").trim();
        System.out.println("Single Spaces: " + singleSpaceCount);
        System.out.println("Double Spaces: " + doubleSpaceCount);
        System.out.println("Multiple Spaces: " + multiSpaceCount);
        System.out.println("Resulted String: " + result);
    }
}