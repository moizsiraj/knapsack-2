import java.util.*;

class EditDistance {
    public static int EditDistance(String s, String t) {
        int[][] valueArray = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < valueArray.length; i++) {
            valueArray[i][0] = i;
        }
        for (int i = 0; i < valueArray[0].length; i++) {
            valueArray[0][i] = i;
        }

        for (int j = 1; j < valueArray[0].length; j++) {
            for (int i = 1; i < valueArray.length; i++) {
                int insertion = valueArray[i][j - 1] + 1;
                int deletion = valueArray[i - 1][j] + 1;
                int match = valueArray[i - 1][j - 1];
                int mismatch = valueArray[i - 1][j - 1] + 1;
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    int minX = Math.min(insertion, deletion);
                    int minY = Math.min(minX, match);
                    valueArray[i][j] = minY;
                } else {
                    int minX = Math.min(insertion, deletion);
                    int minY = Math.min(minX, mismatch);
                    valueArray[i][j] = minY;
                }
            }
        }
        return valueArray[valueArray.length - 1][valueArray[0].length - 1];
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(EditDistance(s, t));
    }

}
