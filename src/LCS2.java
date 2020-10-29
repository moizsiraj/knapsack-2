import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        int[][] array = new int[a.length + 1][b.length + 1];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (i == 0 || j == 0) {
                    array[i][j] = 0;
                } else if (a[i - 1] == b[j - 1]) {
                    array[i][j] = array[i - 1][j - 1] + 1;
                } else {
                    array[i][j] = Math.max(array[i - 1][j], array[i][j - 1]);
                }
            }
        }
        return array[array.length - 1][array[0].length - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

